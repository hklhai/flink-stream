package com.hxqh.analysis.table.task;


import com.hxqh.analysis.table.map.OrderMap;
import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.batch.OrderInfotable;
import com.hxqh.common.table.MerchantOrder;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.api.java.BatchTableEnvironment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Ocean lin on 2019/1/6.
 * <p>
 *
 *
 * @author Ocean lin
 */
public class OrderBatchProcess {

    public static void main(String[] args) {
        // System.setProperty("hadoop.home.dir", "D:\\Program\\hadoop-2.6.0");
        // System.setProperty("hadoop.conf.dir", "D:\\Program\\hadoop-2.6.0\\etc\\hadoop");
        args = new String[]{"--input", "hdfs://192.168.89.129:9000/user/hive/warehouse/order/part-m-00000"};
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        BatchTableEnvironment tEnv = TableEnvironment.getTableEnvironment(env);

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataSet<String> text = env.readTextFile(params.get("input"));
        DataSet<OrderInfotable> map = text.flatMap(new OrderMap());


        String param = "orderid, userid, merchantid, orderamount, paytype, paytime, red, cashcoupon, productid, saleid";
        tEnv.registerDataSet("OrderInfotable", map, param);

        String sql = "SELECT merchantid, sum(orderamount) AS orderamout, count(1) AS countvalue FROM OrderInfotable where paytime is not null GROUP BY merchantid";

        Table table = tEnv.sqlQuery(sql);

        DataSet<MerchantOrder> result = tEnv.toDataSet(table, MerchantOrder.class);

        try {
            result.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<MerchantOrder> list = result.collect();
            for (MerchantOrder merchantOrder : list) {
                Map<String, String> datamap = new HashMap<>(100);
                datamap.put("merchantordercount", merchantOrder.getCountvalue() + "");
                datamap.put("merchantorderamount", merchantOrder.getOrderamout() + "");
                HbaseUtil.put("orderinfo", merchantOrder.getMerchantid() + "", "info", datamap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
