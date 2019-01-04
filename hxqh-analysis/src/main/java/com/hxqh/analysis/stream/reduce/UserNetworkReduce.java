package com.hxqh.analysis.stream.reduce;

import com.hxqh.common.analysis.UserNetwork;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class UserNetworkReduce implements ReduceFunction<UserNetwork> {

    @Override
    public UserNetwork reduce(UserNetwork value1, UserNetwork value2) throws Exception {

        long newcountvalue1 = value1.getNewcount();
        long oldcountvalue1 = value1.getOldcount();
        long countvalue1 = value1.getCount();

        long countvalue2 = value2.getCount();
        long newcountvalue2 = value2.getNewcount();
        long oldcountvalue2 = value2.getOldcount();

        value1.setOldcount(oldcountvalue1 + oldcountvalue2);
        value1.setNewcount(newcountvalue1 + newcountvalue2);
        value1.setCount(countvalue1 + countvalue2);

        System.out.println("recuduce --UserNetworkReduce==" + value1);
        return value1;
    }
}
