package com.hxqh.common.analysis;

/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class PindaoRD {

    private Long pingdaoid;
    private Long count;

    public PindaoRD() {
    }

    public PindaoRD(Long pingdaoid, Long count) {
        this.pingdaoid = pingdaoid;
        this.count = count;
    }

    public Long getPingdaoid() {
        return pingdaoid;
    }

    public void setPingdaoid(Long pingdaoid) {
        this.pingdaoid = pingdaoid;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PindaoRD{");
        sb.append("pingdaoid=").append(pingdaoid);
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
