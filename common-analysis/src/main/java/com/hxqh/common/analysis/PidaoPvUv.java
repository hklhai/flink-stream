package com.hxqh.common.analysis;

/**
 * Created by Ocean lin on 2018/12/23.
 *
 * @author Ocean lin
 */
public class PidaoPvUv {
    private long pingdaoid;
    private long userid;
    private long pvcount;
    private long uvcount;
    private long timestamp;
    private String timestring;
    private String groupbyfield;

    public long getPingdaoid() {
        return pingdaoid;
    }

    public void setPingdaoid(long pingdaoid) {
        this.pingdaoid = pingdaoid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getPvcount() {
        return pvcount;
    }

    public void setPvcount(long pvcount) {
        this.pvcount = pvcount;
    }

    public long getUvcount() {
        return uvcount;
    }

    public void setUvcount(long uvcount) {
        this.uvcount = uvcount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestring() {
        return timestring;
    }

    public void setTimestring(String timestring) {
        this.timestring = timestring;
    }

    public String getGroupbyfield() {
        return groupbyfield;
    }

    public void setGroupbyfield(String groupbyfield) {
        this.groupbyfield = groupbyfield;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PidaoPvUv{");
        sb.append("pingdaoid=").append(pingdaoid);
        sb.append(", userid=").append(userid);
        sb.append(", pvcount=").append(pvcount);
        sb.append(", uvcount=").append(uvcount);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", timestring='").append(timestring).append('\'');
        sb.append(", groupbyfield='").append(groupbyfield).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
