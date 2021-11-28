package com.triforkopgave.rabbit.mq.springrabbitmqconsumer.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.triforkopgave.rabbit.mq.springrabbitmqconsumer.model.Message;

public interface MessageRepo extends MongoRepository<Message,Integer> {


}

