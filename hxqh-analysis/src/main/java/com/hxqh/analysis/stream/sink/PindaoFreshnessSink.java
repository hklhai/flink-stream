package com.hxqh.analysis.stream.sink;

import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.analysis.PidaoFreshness;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2018/12/29.
 *
 * @author Ocean lin
 */
public class PindaoFreshnessSink implements SinkFunction<PidaoFreshness> {
    @Override
    public void invoke(PidaoFreshness value, Context context) throws Exception {
        System.out.println("++++++++++++++++++++++PindaoFreshnessSink:" + value);
        long pingdaoid = value.getPingdaoid();
        long newcount = value.getNewcount();
        long oldcount = value.getOldcount();
        String timestring = value.getTimestring();
        String newcountstring = HbaseUtil.getdata("pindaoinfo", pingdaoid + timestring, "info", "xinxiandunewcount");
        String oldcountstring = HbaseUtil.getdata("pindaoinfo", pingdaoid + timestring, "info", "xinxianduoldcount");
        if (StringUtils.isNotBlank(newcountstring)) {
            newcount += newcount + Long.valueOf(newcountstring);
        }
        if (StringUtils.isNotBlank(oldcountstring)) {
            oldcount += oldcount + Long.valueOf(oldcountstring);
        }
        Map<String, String> datamap = new HashMap<>(5);
        datamap.put("xinxiandunewcount", newcount + "");
        datamap.put("xinxianduoldcount", oldcount + "");
        HbaseUtil.put("pindaoinfo", pingdaoid + timestring, "info", datamap);
    }
}
