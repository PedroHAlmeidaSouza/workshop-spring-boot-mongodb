package com.workshop_spring_boot_mongodb.workshop.repositories;

import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
