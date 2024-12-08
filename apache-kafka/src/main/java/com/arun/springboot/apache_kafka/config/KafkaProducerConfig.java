package com.arun.springboot.apache_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic() {
//        return new NewTopic("arun-robotics", 3, (short) 1);
        return new NewTopic("arun-robotics-command", 3, (short) 1);
    }
}
