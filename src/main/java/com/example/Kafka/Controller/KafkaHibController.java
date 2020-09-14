package com.example.Kafka.Controller;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kafka.Model.User;
import com.example.Kafka.Repository.UserRepository;

@RestController
public class KafkaHibController {

	@Autowired
	 private  UserRepository repository;
	@Autowired
	KafkaTemplate<String,User> kt;

	   //Getting all users from DB and produce to topic
	  @GetMapping("/users")
	  @ResponseStatus(code=HttpStatus.BAD_REQUEST)
	  List<User> all() {
		 List<User> users= repository.findAll();
		
	   users.stream().forEach((user)->{
		   kt.send("bearcat-messages",user);
	   });
	    return users;
	  }
	  //Adding user to DB and Produce to topic
	  @PostMapping(path = "/add-user", consumes = "application/json", produces = "application/json")
		public String addUser(@RequestBody User newUser) {
		    System.out.println(newUser);
		    kt.send("bearcat-messages",newUser);
		    User addedUser = repository.save(newUser);
		    return "Added User"+addedUser.toString();
		}

}
