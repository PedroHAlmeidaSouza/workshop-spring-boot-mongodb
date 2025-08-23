package com.workshop_spring_boot_mongodb.workshop.repositories;

import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String title);
}
