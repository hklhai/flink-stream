package com.hxqh.analysis.stream.sink;

import com.hxqh.common.analysis.PidaoFreshness;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * Created by Ocean lin on 2018/12/29.
 *
 * @author Ocean lin
 */
public class PindaoFreshnessSink implements SinkFunction<PidaoFreshness> {
    @Override
    public void invoke(PidaoFreshness value, Context context) throws Exception {
        System.out.println("++++++++++++++++++++++PidaoPvUv:" + value);
    }
}
