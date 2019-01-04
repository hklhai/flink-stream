package com.hxqh.analysis.stream.sink;

import com.alibaba.fastjson.JSONObject;
import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.analysis.UserNetwork;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2019/1/3.
 *
 * @author Ocean lin
 */
public class UserNetworkSink implements SinkFunction<UserNetwork> {
    @Override
    public void invoke(UserNetwork value, Context context) throws Exception {
        System.out.println("++++++++++++++++++++++UserNetworkSink:" + value);
        String timestring = value.getTimestring();
        String network = value.getNetwork();

        long newcount = value.getNewcount();
        long counttemp = value.getCount();
        long oldcount = value.getOldcount();

        String networkcount = HbaseUtil.getdata("userinfo", timestring, "info", "networkcount");
        String networknewcount = HbaseUtil.getdata("userinfo", timestring, "info", "networknewcount");
        String networkoldcount = HbaseUtil.getdata("userinfo", timestring, "info", "networkoldcount");

        Map<String, String> datamap = new HashMap<>(50);
        Map<String, Long> map = new HashMap<>(50);
        if (StringUtils.isNotBlank(networkcount)) {
            map = JSONObject.parseObject(networkcount, Map.class);
            Long count = map.get(network);
            if (count != null) {
                counttemp += counttemp + count;
            }
        }
        map.put(network, counttemp);
        datamap.put("networkcount", JSONObject.toJSONString(map));


        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(networknewcount)) {
            map = JSONObject.parseObject(networknewcount, Map.class);
            Long count = map.get(network);
            if (count != null) {
                newcount += newcount + count;
            }
        }
        map.put(network, newcount);
        datamap.put("networknewcount", JSONObject.toJSONString(map));


        map = new HashMap<>(50);
        if (StringUtils.isNotBlank(networkoldcount)) {
            map = JSONObject.parseObject(networkoldcount, Map.class);
            Long count = map.get(network);
            if (count != null) {
                oldcount += oldcount + count;
            }
        }
        map.put(network, oldcount);
        datamap.put("networkoldcount", JSONObject.toJSONString(map));

        System.out.println("usernetwork---- HbaseUtil.put(usernetwork+" + "," + timestring + ",info" + datamap + ")");
        HbaseUtil.put("userinfo", timestring, "info", datamap);
    }
}
