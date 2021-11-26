package com.rabbitmqexercisemongodb.rabbitmqexercisemongodb.dao;

import com.rabbitmqexercisemongodb.rabbitmqexercisemongodb.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepo extends MongoRepository<Message,Integer> {

}
