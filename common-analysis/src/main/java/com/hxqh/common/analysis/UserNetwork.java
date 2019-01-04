package com.hxqh.common.analysis;

/**
 * Created by Ocean lin on 2019/1/3.
 *
 * @author Ocean lin
 */
public class UserNetwork {

    private String network;
    private long count;
    private long newcount;
    private long oldcount;
    private long timestamp;
    private String timestring;

    public UserNetwork() {
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserNetwork{");
        sb.append("network='").append(network).append('\'');
        sb.append(", count=").append(count);
        sb.append(", newcount=").append(newcount);
        sb.append(", oldcount=").append(oldcount);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", timestring='").append(timestring).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
