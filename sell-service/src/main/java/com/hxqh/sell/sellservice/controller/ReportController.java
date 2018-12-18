package com.hxqh.sell.sellservice.controller;

import com.alibaba.fastjson.JSON;
import com.hxqh.common.input.KafkaMessage;
import com.hxqh.common.log.UserscanLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Ocean lin on 2018/12/12.
 *
 * @author Ocean lin
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * -- 启动
     * ./kafka-server-start.sh ../config/server.properties
     * -- 创建topic
     * kafka-topics.sh --create --zookeeper=127.0.0.1:2181 --partitions 1 --replication-factor 1 --topic test
     * <p>
     * kafka-console-producer.sh --broker-list 127.0.0.1:9092  --topic test
     * kafka-console-consumer.sh --zookeeper 127.0.0.1:2181 --topic test
     *
     * @param jsonstr
     * @param request
     * @param response
     */
    @RequestMapping(value = "/webInfoSJService", method = RequestMethod.POST)
    public void webInfoSJService(@RequestBody String jsonstr, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("未转换kafkamessage之前的==" + jsonstr);
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setJsonmessage(jsonstr);
        kafkaMessage.setCount(1);
        kafkaMessage.setTimestamp(System.currentTimeMillis());
        jsonstr = JSON.toJSONString(kafkaMessage);

        System.out.println("转换kafkamessage之后的==" + jsonstr);
        // 业务开始
        kafkaTemplate.send("test", "key", jsonstr);
        // 业务结束
        PrintWriter printWriter = getWriter(response);
        response.setStatus(HttpStatus.OK.value());
        printWriter.write("success");
        closeprintwriter(printWriter);
    }

    private PrintWriter getWriter(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        OutputStream out = null;
        PrintWriter printWriter = null;
        try {
            out = response.getOutputStream();
            printWriter = new PrintWriter(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return printWriter;
    }

    private void closeprintwriter(PrintWriter printWriter) {
        printWriter.flush();
        printWriter.close();
    }


}
