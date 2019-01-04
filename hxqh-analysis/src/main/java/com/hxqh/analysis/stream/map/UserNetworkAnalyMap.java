package com.hxqh.analysis.stream.map;

import com.alibaba.fastjson.JSON;
import com.hxqh.analysis.dao.PdvisterDao;
import com.hxqh.analysis.utils.DateUtil;
import com.hxqh.common.analysis.UserNetwork;
import com.hxqh.common.analysis.UserState;
import com.hxqh.common.input.KafkaMessage;
import com.hxqh.common.log.UserscanLog;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * Created by Ocean lin on 2019/1/3.
 *
 * @author Ocean lin
 */
public class UserNetworkAnalyMap implements FlatMapFunction<KafkaMessage, UserNetwork> {

    @Override
    public void flatMap(KafkaMessage value, Collector<UserNetwork> out) throws Exception {
        Long timestamp = value.getTimestamp();

        String jsonmessage = value.getJsonmessage();
        UserscanLog userscanLog = JSON.parseObject(jsonmessage, UserscanLog.class);
        //小时
        String hourtimestamp = DateUtil.getDateby(timestamp, "yyyyMMddhh");
        //天
        String daytimestamp = DateUtil.getDateby(timestamp, "yyyyMMdd");
        //月
        String monthtimestamp = DateUtil.getDateby(timestamp, "yyyyMM");
        String network = userscanLog.getNetwork();
        long userid = userscanLog.getUserid();

        UserState userState = PdvisterDao.getUserSatebyvistertime(userid + "", timestamp);
        boolean isFirsthour = userState.isFisrthour();
        boolean isFisrtday = userState.isFisrtday();
        boolean isFisrtmonth = userState.isFisrtmonth();
        boolean isnew = userState.isIsnew();

        // flatMap 将一个对象拆分为3个对象，属于不同年、不同月、不同日
        UserNetwork userNetwork = new UserNetwork();
        userNetwork.setTimestamp(timestamp);
        userNetwork.setNetwork(network);
        userNetwork.setTimestring(hourtimestamp);
        userNetwork.setCount(1L);
        long newuser = 0L;
        if (isnew) {
            newuser = 1L;
        }
        userNetwork.setNewcount(newuser);


        //小时
        long oldcount = 0L;
        if (isFirsthour) {
            oldcount = 1L;
        }
        userNetwork.setOldcount(oldcount);
        userNetwork.setTimestring(hourtimestamp);
        System.out.println("小时==" + userNetwork);
        out.collect(userNetwork);

        //天
        oldcount = 0L;
        if (isFisrtday) {
            oldcount = 1L;
        }
        userNetwork.setOldcount(oldcount);
        userNetwork.setTimestring(daytimestamp);
        System.out.println("天==" + userNetwork);
        out.collect(userNetwork);


        //月
        oldcount = 0L;
        if (isFisrtmonth) {
            oldcount = 1L;
        }
        userNetwork.setOldcount(oldcount);
        userNetwork.setTimestring(monthtimestamp);
        System.out.println("月==" + userNetwork);
        out.collect(userNetwork);
    }
}
