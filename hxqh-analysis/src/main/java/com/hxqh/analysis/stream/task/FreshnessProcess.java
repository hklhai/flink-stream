package com.hxqh.analysis.stream.task;

import com.hxqh.analysis.stream.map.PindaoFreshnessMap;
import com.hxqh.analysis.stream.reduce.FreshnessReduce;
import com.hxqh.analysis.stream.sink.PindaoFreshnessSink;
import com.hxqh.analysis.stream.transfer.KafkaMessageSchema;
import com.hxqh.analysis.stream.transfer.KafkaMessageWatermarks;
import com.hxqh.common.analysis.PidaoFreshness;
import com.hxqh.common.input.KafkaMessage;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;

/**
 * Created by Ocean lin on 2018/12/28.
 *
 * @author Ocean lin
 */
public class FreshnessProcess {

    private final static Integer NUM = 5;

    public static void main(String[] args) {
        args = new String[]{"--input-topic", "hk", "--bootstrap.servers", "192.168.89.129:9092",
                "--zookeeper.connect", "192.168.89.129:2181", "--group.id", "myconsumer1",
                "--group.id", "myconsumer1", "--windows.size", "2"};

        final ParameterTool parameterTool = ParameterTool.fromArgs(args);

        if (parameterTool.getNumberOfParameters() < NUM) {
            System.out.println("Missing parameters!\n" +
                    "Usage: Kafka --input-topic <topic>" +
                    "--bootstrap.servers <kafka brokers> " +
                    "--zookeeper.connect <zk quorum> --group.id <some id>");
            return;
        }

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.getConfig().disableSysoutLogging();
        env.getConfig().setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000));
        // create a checkpoint every 5 seconds
        env.enableCheckpointing(5000);
        env.getConfig().setGlobalJobParameters(parameterTool);
        // make parameters available in the web interface
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);


        FlinkKafkaConsumer010 flinkKafkaConsumer = new FlinkKafkaConsumer010<>(
                parameterTool.getRequired("input-topic"), new KafkaMessageSchema(), parameterTool.getProperties());
        DataStream<KafkaMessage> input = env.addSource(
                flinkKafkaConsumer.assignTimestampsAndWatermarks(new KafkaMessageWatermarks()));

        DataStream<PidaoFreshness> kafkaMessageMap = input.flatMap(new PindaoFreshnessMap());

        DataStream<PidaoFreshness> reduce = kafkaMessageMap.keyBy("groupbyfield").countWindow(Long.valueOf(parameterTool.getRequired("windows.size")))
                .reduce(new FreshnessReduce());
        reduce.addSink(new PindaoFreshnessSink()).name("PindaoFreshnessSink");

        try {
            env.execute("FreshnessProcess");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
