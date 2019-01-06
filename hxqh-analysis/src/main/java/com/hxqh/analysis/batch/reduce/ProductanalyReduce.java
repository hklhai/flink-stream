package com.hxqh.analysis.batch.reduce;

import com.hxqh.common.batch.ProductAnaly;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class ProductanalyReduce implements ReduceFunction<ProductAnaly> {
    @Override
    public ProductAnaly reduce(ProductAnaly value1, ProductAnaly value2) throws Exception {
        long chengjiaovalue1 = value1.getChengjiaocount();
        long weichegnjiaovalue1 = value1.getWeichegnjiao();

        long chengjiaovalue2 = value1.getChengjiaocount();
        long weichegnjiaovalue2 = value1.getWeichegnjiao();

        value1.setChengjiaocount(chengjiaovalue1 + chengjiaovalue2);
        value1.setWeichegnjiao(weichegnjiaovalue1 + weichegnjiaovalue2);
        return value1;
    }
}
