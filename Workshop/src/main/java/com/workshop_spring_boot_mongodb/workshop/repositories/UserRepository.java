package com.workshop_spring_boot_mongodb.workshop.repositories;

import com.workshop_spring_boot_mongodb.workshop.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
