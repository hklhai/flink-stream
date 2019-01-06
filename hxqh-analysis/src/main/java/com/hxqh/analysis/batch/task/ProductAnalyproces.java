package com.hxqh.analysis.batch.task;

import com.hxqh.analysis.batch.map.ProductanalyMap;
import com.hxqh.analysis.batch.reduce.ProductanalyReduce;
import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.batch.ProductAnaly;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class ProductAnalyproces {

    public static void main(String[] args) {
        final ParameterTool params = ParameterTool.fromArgs(args);

        // set up the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // make parameters available in the web interface
        env.getConfig().setGlobalJobParameters(params);

        // get input data
        DataSet<String> text = env.readTextFile(params.get("input"));
        DataSet<ProductAnaly> map = text.flatMap(new ProductanalyMap());
        DataSet<ProductAnaly> reduce = map.groupBy("groupbyfield").reduce(new ProductanalyReduce());

        try {
            List<ProductAnaly> list = reduce.collect();
            for (ProductAnaly value : list) {
                long productid = value.getProductid();
                String datatime = value.getDateString();
                long chengjiaocount = value.getChengjiaocount();
                long weichengjiaocount = value.getWeichegnjiao();

                Map<String, String> datamap = new HashMap<>(10);
                datamap.put("chengjiaocount", chengjiaocount + "");
                datamap.put("weichengjiaocount", weichengjiaocount + "");
                HbaseUtil.put("pindaoinfo", productid + "==" + datatime, "info", datamap);
            }
            env.execute("ProductAnalyproces");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
