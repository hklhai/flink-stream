package com.hxqh.analysis.stream.reduce;

import com.hxqh.common.analysis.PindaoRD;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class PindaoReduce implements ReduceFunction<PindaoRD> {

    @Override
    public PindaoRD reduce(PindaoRD value1, PindaoRD value2) throws Exception {
        Long count = value1.getCount() + value2.getCount();
        return new PindaoRD(value1.getPingdaoid(), count);
    }
}
