package com.hxqh.analysis.stream.map;

import com.alibaba.fastjson.JSON;
import com.hxqh.analysis.dao.PdvisterDao;
import com.hxqh.analysis.utils.DateUtil;
import com.hxqh.common.analysis.RealTimeArea;
import com.hxqh.common.analysis.UserState;
import com.hxqh.common.input.KafkaMessage;
import com.hxqh.common.log.UserscanLog;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * Created by Ocean lin on 2019/1/2.
 *
 * @author Ocean lin
 */
public class RealTimeAreaMap implements FlatMapFunction<KafkaMessage, RealTimeArea> {

    @Override
    public void flatMap(KafkaMessage value, Collector<RealTimeArea> out) throws Exception {
        String jsonstring = value.getJsonmessage();
        long timestamp = value.getTimestamp();

        String hourtimestamp = DateUtil.getDateby(timestamp, "yyyyMMddhh");
        //天
        String daytimestamp = DateUtil.getDateby(timestamp, "yyyyMMdd");
        //月
        String monthtimestamp = DateUtil.getDateby(timestamp, "yyyyMM");

        UserscanLog userscanLog = JSON.parseObject(jsonstring, UserscanLog.class);
        long pingdaoid = userscanLog.getPingdaoid();
        long userid = userscanLog.getUserid();
        //  城市
        String city = userscanLog.getCity();
        UserState userState = PdvisterDao.getUserSatebyvistertime(userid + "", timestamp);
        boolean isFirsthour = userState.isFisrthour();
        boolean isFisrtday = userState.isFisrtday();
        boolean isFisrtmonth = userState.isFisrtmonth();
        RealTimeArea realTimeArea = new RealTimeArea();

        realTimeArea.setPingdaoid(pingdaoid);
        realTimeArea.setArea(city);
        realTimeArea.setPv(1L);

        long newcount = 0L;
        if (userState.isIsnew()) {
            newcount = 1L;
        }
        realTimeArea.setNewcount(newcount);

        //小时
        long uvcount = 0L;
        long oldcount = 0L;
        if (isFirsthour) {
            uvcount = 1L;
            oldcount = 1L;
        }
        realTimeArea.setUv(uvcount);
        realTimeArea.setOldcount(oldcount);
        realTimeArea.setTimestamp(timestamp);
        realTimeArea.setTimestring(hourtimestamp);
        realTimeArea.setGroupbyfield(pingdaoid + hourtimestamp);
        out.collect(realTimeArea);

        //天
        uvcount = 0L;
        oldcount = 0L;
        if (isFisrtday) {
            uvcount = 1L;
            oldcount = 1L;
        }
        realTimeArea.setUv(uvcount);
        realTimeArea.setOldcount(oldcount);
        realTimeArea.setTimestamp(timestamp);
        realTimeArea.setTimestring(daytimestamp);
        realTimeArea.setGroupbyfield(pingdaoid + daytimestamp);
        out.collect(realTimeArea);

        //月
        uvcount = 0L;
        oldcount = 0L;
        if (isFisrtmonth) {
            uvcount = 1L;
            oldcount = 1L;
        }
        realTimeArea.setUv(uvcount);
        realTimeArea.setOldcount(oldcount);
        realTimeArea.setTimestamp(timestamp);
        realTimeArea.setTimestring(monthtimestamp);
        realTimeArea.setGroupbyfield(pingdaoid + monthtimestamp);
        out.collect(realTimeArea);

    }
}
