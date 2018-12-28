package com.hxqh.analysis.stream.sink;

import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.analysis.PidaoPvUv;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2018/12/24.
 *
 * @author Ocean lin
 */
public class PindaoPvUvSink implements SinkFunction<PidaoPvUv> {
    @Override
    public void invoke(PidaoPvUv value, Context context) throws Exception {
        System.out.println("++++++++++++++++++++++PidaoPvUv:"+value);
        long pingdaoid = value.getPingdaoid();
        long pvcount = value.getPvcount();
        long uvcount = value.getUvcount();
        String timesSring = value.getTimestring();

        String pv = HbaseUtil.getdata("pindaoinfo", pingdaoid + timesSring, "info", "pv");
        String uv = HbaseUtil.getdata("pindaoinfo", pingdaoid + timesSring, "info", "uv");
        if (StringUtils.isNotBlank(pv)) {
            pvcount += pvcount + Long.valueOf(pv);
        }
        if (StringUtils.isNotBlank(uv)) {
            uvcount += uvcount + Long.valueOf(uv);
        }
        Map<String, String> datamap = new HashMap<>(10);
        datamap.put("pv", pvcount + "");
        datamap.put("uv", uvcount + "");
        HbaseUtil.put("pindaoinfo", pingdaoid + timesSring, "info", datamap);

    }
}
