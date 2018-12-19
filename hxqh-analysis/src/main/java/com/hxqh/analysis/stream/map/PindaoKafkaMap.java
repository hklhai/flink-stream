package com.hxqh.analysis.stream.map;

import com.alibaba.fastjson.JSON;
import com.hxqh.common.analysis.PindaoRD;
import com.hxqh.common.input.KafkaMessage;
import com.hxqh.common.log.UserscanLog;
import org.apache.flink.api.common.functions.RichMapFunction;

/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class PindaoKafkaMap extends RichMapFunction<KafkaMessage, PindaoRD> {

    @Override
    public PindaoRD map(KafkaMessage value) throws Exception {
        String jsonmessage = value.getJsonmessage();
        UserscanLog userscanLog = JSON.parseObject(jsonmessage, UserscanLog.class);
        Long pingdaoid = userscanLog.getPingdaoid();
        int count = value.getCount();
        PindaoRD pindaoRD = new PindaoRD();
        pindaoRD.setPingdaoid(pingdaoid);
        pindaoRD.setCount(Long.valueOf(count + ""));
        System.out.println("=======" + pingdaoid);
        return pindaoRD;
    }
}
