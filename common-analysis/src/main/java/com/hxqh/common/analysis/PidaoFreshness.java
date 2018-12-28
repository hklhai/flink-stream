package com.hxqh.common.analysis;

/**
 * Created by Ocean lin on 2018/12/27.
 *
 * @author Ocean lin
 */
public class PidaoFreshness {

    private long pingdaoid;
    private long newcount;
    private long oldcount;
    private long timestamp;
    private String timestring;
    private String groupbyfield;

    public long getPingdaoid() {
        return pingdaoid;
    }

    public void setPingdaoid(long pingdaoid) {
        this.pingdaoid = pingdaoid;
    }

    public long getNewcount() {
        return newcount;
    }

    public void setNewcount(long newcount) {
        this.newcount = newcount;
    }

    public long getOldcount() {
        return oldcount;
    }

    public void setOldcount(long oldcount) {
        this.oldcount = oldcount;
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
        final StringBuilder sb = new StringBuilder("PidaoFreshness{");
        sb.append("pingdaoid=").append(pingdaoid);
        sb.append(", newcount=").append(newcount);
        sb.append(", oldcount=").append(oldcount);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", timestring='").append(timestring).append('\'');
        sb.append(", groupbyfield='").append(groupbyfield).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
