package com.arun.springboot.apache_kafka.controller;

import com.arun.dto.MachineCommand;
import com.arun.springboot.apache_kafka.model.Robot;
import com.arun.springboot.apache_kafka.service.KafkaMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/welcome")
    public String APICheck() {
        return "Hello All";
    }

    @GetMapping("/send")
    public ResponseEntity<?> publishMessage(@RequestParam("message") String message) {
        try{
            for(int i=0; i<1000; i++) {
                publisher.sendMessageToTopic(message);
            }

            return ResponseEntity.ok("Message Sent Successfully...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/send/events")
    public ResponseEntity<?> publishEvent(@RequestBody MachineCommand cmd) {
        try{
          publisher.sendEventsToTopic(cmd);
          return ResponseEntity.ok("Message Sent Successfully...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
