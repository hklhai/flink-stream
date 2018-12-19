package com.hxqh.analysis.utils;

import redis.clients.jedis.Jedis;

/**
 * @author Lin
 */
public class RedisUtil {

    public static final Jedis jedis = new Jedis("192.168.89.129", 6379);

    public static String getBykey(String key) {
        return jedis.get(key);
    }

    public static void main(String[] args) {
        jedis.set("test2", "test22");
        String value = jedis.get("test2");
        System.out.println(value);
    }
}
