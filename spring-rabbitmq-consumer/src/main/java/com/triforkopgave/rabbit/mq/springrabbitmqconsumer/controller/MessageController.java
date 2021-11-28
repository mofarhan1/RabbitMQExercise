package com.triforkopgave.rabbit.mq.springrabbitmqconsumer.controller;


import com.triforkopgave.rabbit.mq.springrabbitmqconsumer.dao.MessageRepo;
import com.triforkopgave.rabbit.mq.springrabbitmqconsumer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class MessageController {
    private MessageRepo repository;

    public Message saveMessage(Message msg) {
        return repository.save(msg);


    }

    public List<Message> getMessage() {
        return repository.findAll();
    }


}
