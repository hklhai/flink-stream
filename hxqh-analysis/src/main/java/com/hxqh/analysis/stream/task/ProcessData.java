package com.hxqh.analysis.stream.task;


import com.hxqh.analysis.stream.map.PindaoKafkaMap;
import com.hxqh.analysis.stream.reduce.PindaoReduce;
import com.hxqh.analysis.stream.transfer.KafkaMessageSchema;
import com.hxqh.analysis.stream.transfer.KafkaMessageWatermarks;
import com.hxqh.common.analysis.PindaoRD;
import com.hxqh.common.input.KafkaMessage;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;


/**
 * Created by Ocean lin on 2018/12/18.
 *
 * @author Ocean lin
 */
public class ProcessData {
    private final static Integer NUM = 4;

    public static void main(String[] args) throws Exception {
        args = new String[]{"--input-topic", "test", "--bootstrap.servers", "192.168.89.129:9092",
                "--zookeeper.connect", "192.168.89.129:2181", "--group.id", "myconsumer1"};

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


        FlinkKafkaConsumer010 flinkKafkaConsumer = new FlinkKafkaConsumer010<KafkaMessage>(
                parameterTool.getRequired("input-topic"), new KafkaMessageSchema(), parameterTool.getProperties());
        DataStream<KafkaMessage> input = env.addSource(
                flinkKafkaConsumer.assignTimestampsAndWatermarks(new KafkaMessageWatermarks()));

        DataStream<PindaoRD> kafkaMessageMap = input.map(new PindaoKafkaMap());
        DataStream<PindaoRD> pingdaoid = kafkaMessageMap.keyBy("pingdaoid").countWindow(10, 5).reduce(new PindaoReduce());
        pingdaoid.print();
        env.execute("pindaoRd");
    }
}
