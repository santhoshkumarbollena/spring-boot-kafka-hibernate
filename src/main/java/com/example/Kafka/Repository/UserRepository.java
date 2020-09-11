package com.example.Kafka.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<com.example.Kafka.Model.User,Integer> {

}
