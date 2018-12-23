package com.hxqh.common.analysis;

/**
 * Created by Ocean lin on 2018/12/23.
 *
 * @author Ocean lin
 */
public class UserState {
    /**
     * 是否是新来的用户
     */
    private boolean isnew = false;
    /**
     * 是否是小时第一次来
     */
    private boolean isFisrthour = false;
    /**
     * 是否是今天第一次来
     */
    private boolean isFisrtday = false;
    /**
     * 是否是这个月第一次来
     */
    private boolean isFisrtmonth = false;

    public boolean isIsnew() {
        return isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }

    public boolean isFisrthour() {
        return isFisrthour;
    }

    public void setFisrthour(boolean fisrthour) {
        isFisrthour = fisrthour;
    }

    public boolean isFisrtday() {
        return isFisrtday;
    }

    public void setFisrtday(boolean fisrtday) {
        isFisrtday = fisrtday;
    }

    public boolean isFisrtmonth() {
        return isFisrtmonth;
    }

    public void setFisrtmonth(boolean fisrtmonth) {
        isFisrtmonth = fisrtmonth;
    }
}
