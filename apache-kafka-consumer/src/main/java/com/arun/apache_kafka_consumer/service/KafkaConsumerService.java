package com.arun.apache_kafka_consumer.service;

import com.arun.apache_kafka_consumer.model.Robot;
import com.arun.dto.MachineCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerService {

    Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "arun-robotics-command", groupId = "instance-group-3")
    public void consume_1(MachineCommand cmd) {
        log.info("Consumer -1 Received Message from Producer {}", cmd.toString());
    }

//    create multiple consumer instances
//    @KafkaListener(topics = "arun-robotics", groupId = "instance-group")
//    public void consume_2(String message) {
//        log.info("Consumer -2 Received Message from Producer {}", message);
//    }
//
//    @KafkaListener(topics = "arun-robotics", groupId = "instance-group")
//    public void consume_3(String message) {
//        log.info("Consumer -3 Received Message from Producer {}", message);
//    }
}
