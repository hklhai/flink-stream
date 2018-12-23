package com.hxqh.analysis.stream.map;

import com.alibaba.fastjson.JSON;
import com.hxqh.analysis.dao.PdvisterDao;
import com.hxqh.analysis.utils.DateUtil;
import com.hxqh.common.analysis.PidaoPvUv;
import com.hxqh.common.analysis.UserState;
import com.hxqh.common.input.KafkaMessage;
import com.hxqh.common.log.UserscanLog;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * Created by Ocean lin on 2018/12/23.
 *
 * @author Ocean lin
 */
public class PindaoPvUvMap implements FlatMapFunction<KafkaMessage, PidaoPvUv> {

    @Override
    public void flatMap(KafkaMessage value, Collector<PidaoPvUv> out) throws Exception {
        Long timestamp = value.getTimestamp();

        String jsonmessage = value.getJsonmessage();
        UserscanLog userscanLog = JSON.parseObject(jsonmessage, UserscanLog.class);
        //小时
        String hourtimestamp = DateUtil.getDateby(timestamp, "yyyyMMddhh");
        //天
        String daytimestamp = DateUtil.getDateby(timestamp, "yyyyMMdd");
        //月
        String monthtimestamp = DateUtil.getDateby(timestamp, "yyyyMM");
        long pingdaoid = userscanLog.getPingdaoid();
        long userid = userscanLog.getUserid();

        UserState userState = PdvisterDao.getUserSatebyvistertime(userid + "", timestamp);
        boolean isFirsthour = userState.isFisrthour();
        boolean isFisrtday = userState.isFisrtday();
        boolean isFisrtmonth = userState.isFisrtmonth();

        PidaoPvUv pidaoPvUv = new PidaoPvUv();
        pidaoPvUv.setPingdaoid(pingdaoid);
        pidaoPvUv.setUserid(userid);
        pidaoPvUv.setPvcount(Long.valueOf(value.getCount() + ""));
        pidaoPvUv.setUvcount(isFirsthour == true ? 1L : 0L);
        pidaoPvUv.setTimestamp(timestamp);
        pidaoPvUv.setTimestring(hourtimestamp);
        pidaoPvUv.setGroupbyfield(hourtimestamp + pingdaoid);
        out.collect(pidaoPvUv);
        System.out.println("小时==" + pidaoPvUv);
        //天
        pidaoPvUv.setUvcount(isFisrtday == true ? 1L : 0L);
        pidaoPvUv.setGroupbyfield(daytimestamp + pingdaoid);
        pidaoPvUv.setTimestring(daytimestamp);
        out.collect(pidaoPvUv);
        System.out.println("天==" + pidaoPvUv);
        //月
        pidaoPvUv.setUvcount(isFisrtmonth == true ? 1L : 0L);
        pidaoPvUv.setGroupbyfield(monthtimestamp + pingdaoid);
        pidaoPvUv.setTimestring(monthtimestamp);
        out.collect(pidaoPvUv);
        System.out.println("月==" + pidaoPvUv);


    }
}
