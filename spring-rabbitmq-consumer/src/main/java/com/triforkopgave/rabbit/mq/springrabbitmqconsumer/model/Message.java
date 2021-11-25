package com.triforkopgave.rabbit.mq.springrabbitmqconsumer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
    private int id;
    private String name;
    private long time_ms;
}
