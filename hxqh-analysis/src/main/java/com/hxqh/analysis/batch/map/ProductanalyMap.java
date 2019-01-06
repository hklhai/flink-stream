package com.hxqh.analysis.batch.map;

import com.alibaba.fastjson.JSONObject;
import com.hxqh.analysis.utils.DateUtil;
import com.hxqh.common.batch.OrderInfo;
import com.hxqh.common.batch.ProductAnaly;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.Date;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class ProductanalyMap implements FlatMapFunction<String, ProductAnaly> {
    @Override
    public void flatMap(String value, Collector<ProductAnaly> out) throws Exception {

        OrderInfo orderInfo = JSONObject.parseObject(value, OrderInfo.class);
        long productid = orderInfo.getProductid();
        Date date = orderInfo.getCreatetime();
        String timestring = DateUtil.getDateby(date.getTime(), "yyyyMM");
        Date paytime = orderInfo.getPaytime();

        //成交
        long chengjiaocount = 0L;
        //未成交
        long weichegnjiao = 0;
        if (paytime != null) {
            chengjiaocount = 1L;
        } else {
            weichegnjiao = 0L;
        }

        ProductAnaly productAnaly = new ProductAnaly();
        productAnaly.setProductid(productid);
        productAnaly.setDateString(timestring);
        productAnaly.setChengjiaocount(chengjiaocount);
        productAnaly.setWeichegnjiao(weichegnjiao);
        productAnaly.setGroupbyfield(timestring + productid);
        out.collect(productAnaly);

    }
}
