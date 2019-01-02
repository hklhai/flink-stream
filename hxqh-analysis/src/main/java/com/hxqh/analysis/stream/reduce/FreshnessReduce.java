package com.hxqh.analysis.stream.reduce;

import com.hxqh.common.analysis.PidaoFreshness;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2018/12/29.
 *
 * @author Ocean lin
 */
public class FreshnessReduce implements ReduceFunction<PidaoFreshness> {

    @Override
    public PidaoFreshness reduce(PidaoFreshness value1, PidaoFreshness value2) throws Exception {
        long value1Newcount = value1.getNewcount();
        long value1Oldcount = value1.getOldcount();
        long value2Newcount = value2.getNewcount();
        long value2Oldcount = value2.getOldcount();
        value1.setNewcount(value1Newcount + value2Newcount);
        value1.setOldcount(value1Oldcount + value2Oldcount);

        System.out.println("recuduce --FreshnessReduce==" + value1);
        return value1;
    }
}
