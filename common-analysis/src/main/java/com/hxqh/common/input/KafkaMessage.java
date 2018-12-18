package com.hxqh.common.input;

/**
 * @author Lin
 */
public class KafkaMessage {
    /**
     * json格式的消息内容
     */
    private String jsonmessage;

    /**
     * 消息的次数
     */
    private int count;
    /**
     * 消息的时间
     */
    private Long timestamp;

    public String getJsonmessage() {
        return jsonmessage;
    }

    public void setJsonmessage(String jsonmessage) {
        this.jsonmessage = jsonmessage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
