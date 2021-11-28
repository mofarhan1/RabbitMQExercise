package com.triforkopgave.rabbit.mq.springrabbitmqconsumer.model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Getter
@Setter
@ToString
@Document(collection = "students")
public class Message {
    @Id
    private int id;
    private String name;
    private long time_ms;
}
