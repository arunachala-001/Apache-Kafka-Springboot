package com.arun.springboot.apache_kafka.service;

import com.arun.dto.MachineCommand;
import com.arun.springboot.apache_kafka.model.Robot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;


    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("arun-robotics-event", message);

        future.whenComplete((result, exception) -> {
            if(exception==null) {
                System.out.println("Sent message : "+message+" with offset["+result.getRecordMetadata().offset()
                +"]");
            } else {
                System.out.println("Unable to send Message");
            }
        });
    }

    public void sendEventsToTopic(MachineCommand cmd) {
        CompletableFuture<SendResult<String, Object>> future = template.send("arun-robotics-command", cmd);

        future.whenComplete((result, exception) -> {
            if(exception==null) {
                System.out.println("Sent message : "+cmd.toString()+" with offset["+result.getRecordMetadata().offset()
                        +"]");
            } else {
                System.out.println("Unable to send Message");
            }
        });
    }
}
