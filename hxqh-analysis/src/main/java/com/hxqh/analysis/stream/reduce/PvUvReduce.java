package com.hxqh.analysis.stream.reduce;

import com.hxqh.common.analysis.PidaoPvUv;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class PvUvReduce implements ReduceFunction<PidaoPvUv> {

    @Override
    public PidaoPvUv reduce(PidaoPvUv value1, PidaoPvUv value2) throws Exception {

        long pvcountvalue1 = value1.getPvcount();
        long uvcountvalue1 = value1.getUvcount();
        long pvcountvalue2 = value2.getPvcount();
        long uvcountvalue2 = value2.getUvcount();

        value1.setPvcount(pvcountvalue1 + pvcountvalue2);
        value1.setUvcount(uvcountvalue1 + uvcountvalue2);

        System.out.println("recuduce --pidaoPvUv==" + value1);
        return value1;
    }
}
