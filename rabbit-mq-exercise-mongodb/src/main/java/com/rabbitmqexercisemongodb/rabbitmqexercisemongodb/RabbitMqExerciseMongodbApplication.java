package com.rabbitmqexercisemongodb.rabbitmqexercisemongodb;

import com.rabbitmqexercisemongodb.rabbitmqexercisemongodb.dao.MessageRepo;
import com.rabbitmqexercisemongodb.rabbitmqexercisemongodb.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/msg")
public class RabbitMqExerciseMongodbApplication {
	@Autowired
	private MessageRepo repository;
@PostMapping
	public Message saveMessage(@RequestBody Message msg){
return  repository.save(msg);

}
@GetMapping
public List<Message> getMessage(){
	return repository.findAll();
}
	public static void main(String[] args) {

		SpringApplication.run(RabbitMqExerciseMongodbApplication.class, args);
	}

}
