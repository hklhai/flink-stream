package com.hxqh.analysis.table.map;

import com.hxqh.common.batch.OrderInfotable;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */
public class OrderMap implements FlatMapFunction<String, OrderInfotable> {

    @Override
    public void flatMap(String value, Collector<OrderInfotable> out) throws Exception {
        String[] tempArray = value.split("\t");

        String orderid = tempArray[0];
        String userid = tempArray[1];
        String mechartid = tempArray[2];
        double orderamount = Double.valueOf(tempArray[3]);
        String paytype = tempArray[4];
        String paytime = tempArray[5];
        String hbamount = tempArray[6];
        String djjamount = tempArray[7];
        String productid = tempArray[8];
        String huodongnumber = tempArray[9];
        String createtime = tempArray[10];

        OrderInfotable orderInfo = new OrderInfotable(orderid, userid, mechartid, orderamount, paytype, paytime, hbamount, djjamount, productid, huodongnumber, createtime);
        out.collect(orderInfo);
    }
}
