package com.example.Kafka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kafka.Model.User;
import com.example.Kafka.Repository.UserRepository;

@RestController
public class KafkaHibController {

	@Autowired
	 private  UserRepository repository;
	@Autowired
	KafkaTemplate<String,String> kt;

	  @GetMapping("/users")
	  List<User> all() {
		 List<User> users= repository.findAll();
	    kt.send("bearcat-messages",users.toString());
	    return users;
	  }
	  
	  @PostMapping(path = "/add-user", consumes = "application/json", produces = "application/json")
		public String addUser(@RequestBody User newUser) {
		    System.out.println(newUser);
		    kt.send("bearcat-messages",newUser.toString());
		    User addedUser = repository.save(newUser);
		    return "Added User"+addedUser.toString();
		}

}
