package com.rabbitmqexercisemongodb.rabbitmqexercisemongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "message")
public class Message {
    @Id
    private int id;
    private String name;
    private long time_ms;
}

