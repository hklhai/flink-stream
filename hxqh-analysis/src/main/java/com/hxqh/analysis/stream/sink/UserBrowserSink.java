package com.hxqh.analysis.stream.sink;

import com.alibaba.fastjson.JSONObject;
import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.analysis.UserBrowser;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2019/1/3.
 *
 * @author Ocean lin
 */
public class UserBrowserSink implements SinkFunction<UserBrowser> {
    @Override
    public void invoke(UserBrowser value, Context context) throws Exception {
        System.out.println("++++++++++++++++++++++PidaoPvUv:" + value);
        String timestring = value.getTimestring();
        long newcount = value.getNewcount();
        long counttemp = value.getCount();
        long oldcount = value.getOldcount();
        String browser = value.getBrower();


        String browsercount = HbaseUtil.getdata("userinfo", timestring, "info", "browsercount");
        String browsernewcount = HbaseUtil.getdata("userinfo", timestring, "info", "browsernewcount");
        String browseroldcount = HbaseUtil.getdata("userinfo", timestring, "info", "browseroldcount");


        Map<String, String> datamap = new HashMap<>(100);


        Map<String, Long> map = new HashMap<>(50);
        if (StringUtils.isNotBlank(browsercount)) {

            map = JSONObject.parseObject(browsercount, Map.class);
            Long count = map.get(browser);
            if (count != null) {
                counttemp += counttemp + count;
            }
        }

        map.put(browser, counttemp);
        datamap.put("browsercount", JSONObject.toJSONString(map));


        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(browsernewcount)) {
            map = JSONObject.parseObject(browsernewcount, Map.class);
            Long count = map.get(browser);
            if (count != null) {
                newcount += newcount + count;
            }
        }
        map.put(browser, newcount);
        datamap.put("browsernewcount", JSONObject.toJSONString(map));


        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(browseroldcount)) {
            map = JSONObject.parseObject(browseroldcount, Map.class);
            Long count = map.get(browser);
            if (count != null) {
                oldcount += oldcount + count;
            }
        }
        map.put(browser, oldcount);
        datamap.put("browseroldcount", JSONObject.toJSONString(map));

        HbaseUtil.put("userinfo",timestring,"info",datamap);
    }
}