package com.hxqh.analysis.dao;

import com.hxqh.analysis.utils.DateUtil;
import com.hxqh.analysis.utils.HbaseUtil;
import com.hxqh.common.analysis.UserState;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2018/12/23.
 *
 * @author Ocean lin
 */
public class PdvisterDao {
    /**
     * 查询本次用户的访问状态
     *
     * @param userid
     * @param timestamp
     * @return
     */
    public static UserState getUserSatebyvistertime(String userid, long timestamp) {
        UserState userState = new UserState();
        try {
            String result = HbaseUtil.getdata("baseuserscaninfo", userid, "time", "firstvisittime");
            //第一次访问
            if (result == null) {
                Map<String, String> datamap = new HashMap<>(30);
                datamap.put("firstvisittime", timestamp + "");
                datamap.put("lastvisittime", timestamp + "");

                HbaseUtil.put("baseuserscaninfo", userid, "time", datamap);
                userState.setIsnew(true);
                userState.setFisrtday(true);
                userState.setFisrthour(true);
                userState.setFisrtmonth(true);
            } else {
                String lastvisittimestring = HbaseUtil.getdata("baseuserscaninfo", userid, "time", "lastvisittime");
                if (StringUtils.isNotBlank(lastvisittimestring)) {
                    long lastvisittime = Long.valueOf(lastvisittimestring);
                    //小时
                    long timstamp = DateUtil.getDateByCondition(timestamp, "yyyyMMddhh");
                    if (lastvisittime < timestamp) {
                        userState.setFisrthour(true);
                    }
                    //天
                    timstamp = DateUtil.getDateByCondition(timestamp, "yyyyMMdd");
                    if (lastvisittime < timestamp) {
                        userState.setFisrtday(true);
                    }
                    //月
                    timstamp = DateUtil.getDateByCondition(timestamp, "yyyyMM");
                    if (lastvisittime < timestamp) {
                        userState.setFisrtmonth(true);
                    }
                }
                HbaseUtil.putdata("baseuserscaninfo", userid, "time", "lastvisittime", timestamp + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userState;
    }
}
