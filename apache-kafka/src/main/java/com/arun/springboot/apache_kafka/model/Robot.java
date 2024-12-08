package com.arun.springboot.apache_kafka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Robot {

    private int id;
    private String command;

}
