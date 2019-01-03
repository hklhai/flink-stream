package com.hxqh.analysis.stream.reduce;

import com.hxqh.common.analysis.RealTimeArea;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2019/1/2.
 *
 * @author Ocean lin
 */
public class RealTimeAreaReduce implements ReduceFunction<RealTimeArea> {

    @Override
    public RealTimeArea reduce(RealTimeArea value1, RealTimeArea value2) throws Exception {
        long newcount1 = value1.getNewcount();
        long oldcount1 = value1.getOldcount();
        long pv = value1.getPv();
        long uv = value1.getUv();

        long newcount2 = value2.getNewcount();
        long oldcount2 = value2.getOldcount();
        long pv2 = value2.getPv();
        long uv2 = value2.getUv();
        value1.setPv(pv + pv2);
        value1.setUv(uv + uv2);
        value1.setNewcount(newcount1 + newcount2);
        value1.setOldcount(oldcount1 + oldcount2);
        System.out.println("recuduce --RealTimeAreaReduce==" + value1);
        return value1;
    }


}
