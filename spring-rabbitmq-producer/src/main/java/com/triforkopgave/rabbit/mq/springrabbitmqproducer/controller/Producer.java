package com.triforkopgave.rabbit.mq.springrabbitmqproducer.controller;


import org.springframework.amqp.core.DirectExchange;
import com.triforkopgave.rabbit.mq.springrabbitmqproducer.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Timer;


@RestController
public class Producer {
@Autowired
private RabbitTemplate rabbitTemplate;
@Autowired
private DirectExchange directExchange;
@PostMapping("/post")
public String send(@RequestBody Message message){

message.setTime_ms(System.currentTimeMillis());

    rabbitTemplate.convertAndSend(directExchange.getName(),"routing.A",message);
message.setTime_ms(System.currentTimeMillis());
        return"message sent successfully";
        }

}

