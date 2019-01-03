package com.hxqh.analysis.stream.sink;

import com.alibaba.fastjson.JSONObject;
import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.analysis.RealTimeArea;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2019/1/2.
 *
 * @author Ocean lin
 */
public class RealTimeAreaSink implements SinkFunction<RealTimeArea> {
    @Override
    public void invoke(RealTimeArea value, Context context) throws Exception {
        System.out.println("++++++++++++++++++++++RealTimeAreaSink:" + value);
        long pingdaoid = value.getPingdaoid();
        String area = value.getArea();
        long pvcount = value.getPv();
        long uvcount = value.getUv();
        String timestring = value.getTimestring();
        long newcount = value.getNewcount();
        long oldcount = value.getOldcount();

        String pv = HbaseUtil.getdata("pindaoinfo", pingdaoid + timestring, "info", "areapv");
        String uv = HbaseUtil.getdata("pindaoinfo", pingdaoid + timestring, "info", "areauv");

        String areanewcount = HbaseUtil.getdata("pindaoinfo", pingdaoid + timestring, "info", "areanewcount");
        String areaoldcount = HbaseUtil.getdata("pindaoinfo", pingdaoid + timestring, "info", "areaoldcount");

        Map<String, String> datamap = new HashMap<>(10);

        Map<String, Long> map = new HashMap<>(50);
        if (StringUtils.isNotBlank(pv)) {
            map = JSONObject.parseObject(pv, Map.class);
            Long count = map.get(area);
            if (null != count) {
                pvcount += pvcount + count;
            }
        }
        map.put(area, pvcount);
        datamap.put("areapv", JSONObject.toJSONString(map));

        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(uv)) {
            map = JSONObject.parseObject(uv, Map.class);
            Long count = map.get(area);
            if (null != count) {
                uvcount += uvcount + count;
            }
        }
        map.put(area, uvcount);
        datamap.put("areauv", JSONObject.toJSONString(map));


        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(areanewcount)) {
            map = JSONObject.parseObject(areanewcount, Map.class);
            Long count = map.get(area);
            if (count != null) {
                newcount += newcount + count;
            }
        }


        map.put(area, newcount);
        datamap.put("areanewcount", JSONObject.toJSONString(map));
        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(areaoldcount)) {
            map = JSONObject.parseObject(areaoldcount, Map.class);
            Long count = map.get(area);
            if (count != null) {
                oldcount += oldcount + count;
            }
        }
        map.put(area, oldcount);
        datamap.put("areaoldcount", JSONObject.toJSONString(map));

        HbaseUtil.put("pindaoinfo", pingdaoid + timestring, "info", datamap);
    }
}
