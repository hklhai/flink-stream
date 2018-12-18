package com.hxqh.sell.sellservice;

import com.hxqh.sell.sellservice.utils.UrlSendUtil;

/**
 * Created by Ocean lin on 2018/12/13.
 *
 * @author Ocean lin
 */
public class SellClientTest {

    public static void main(String[] args) {
        String message = "kafkatest";
        String adrress = "http://127.0.0.1:8888/report/webInfoSJService";
        UrlSendUtil.sendmessage(adrress, message);
    }
}
