package com.hxqh.analysis.stream.reduce;

import com.hxqh.common.analysis.UserBrowser;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class UserBrowserReduce implements ReduceFunction<UserBrowser> {

    @Override
    public UserBrowser reduce(UserBrowser value1, UserBrowser value2) throws Exception {
        long countvalue1 = value1.getCount();
        long newcountvalue1 = value1.getNewcount();
        long oldcountvalue1 = value1.getOldcount();

        long countvalue2 = value2.getCount();
        long newcountvalue2 = value2.getNewcount();
        long oldcountvalue2 = value2.getOldcount();

        value1.setOldcount(oldcountvalue1 + oldcountvalue2);
        value1.setNewcount(newcountvalue1 + newcountvalue2);
        value1.setCount(countvalue1 + countvalue2);

        System.out.println("recuduce --UserBrowserReduce==" + value1);
        return value1;
    }
}
