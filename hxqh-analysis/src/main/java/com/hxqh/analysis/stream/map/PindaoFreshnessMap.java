package com.hxqh.analysis.stream.map;

import com.alibaba.fastjson.JSON;
import com.hxqh.analysis.dao.PdvisterDao;
import com.hxqh.analysis.utils.DateUtil;
import com.hxqh.common.analysis.PidaoFreshness;
import com.hxqh.common.analysis.UserState;
import com.hxqh.common.input.KafkaMessage;
import com.hxqh.common.log.UserscanLog;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * Created by Ocean lin on 2018/12/29.
 *
 * @author Ocean lin
 */
public class PindaoFreshnessMap implements FlatMapFunction<KafkaMessage, PidaoFreshness> {

    @Override
    public void flatMap(KafkaMessage value, Collector<PidaoFreshness> out) throws Exception {
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

        // flatMap 将一个对象拆分为3个对象，属于不同年、不同月、不同日
        PidaoFreshness pidaoFreshness = new PidaoFreshness();

        pidaoFreshness.setPingdaoid(pingdaoid);
        pidaoFreshness.setTimestamp(timestamp);
        /**
         * 新增用户
         */
        long newuser = 0L;
        if (userState.isIsnew()) {
            newuser = 1L;
        }
        pidaoFreshness.setNewcount(newuser);
        /**
         * 小时
         * 不是新增用户，并且是第一次访问
         */
        long olduser = 0L;
        if (!userState.isIsnew() && isFirsthour) {
            olduser = 1L;
        }
        pidaoFreshness.setOldcount(olduser);
        pidaoFreshness.setTimestring(hourtimestamp);
        pidaoFreshness.setGroupbyfield(hourtimestamp + pingdaoid);
        out.collect(pidaoFreshness);
        System.out.println("小时 map=========" + pidaoFreshness);
        /**
         * 天
         */
        olduser = 0L;
        if (!userState.isIsnew() && isFisrtday) {
            olduser = 1L;
        }
        pidaoFreshness.setOldcount(olduser);
        pidaoFreshness.setTimestring(daytimestamp);
        pidaoFreshness.setGroupbyfield(daytimestamp + pingdaoid);
        out.collect(pidaoFreshness);
        System.out.println("天 map=========" + pidaoFreshness);

        /**
         * 月
         */
        olduser = 0L;
        if (!userState.isIsnew() && isFisrtmonth) {
            olduser = 1L;
        }
        pidaoFreshness.setOldcount(olduser);
        pidaoFreshness.setTimestring(monthtimestamp);
        pidaoFreshness.setGroupbyfield(monthtimestamp + pingdaoid);
        out.collect(pidaoFreshness);
        System.out.println("月 map=========" + pidaoFreshness);

    }
}
