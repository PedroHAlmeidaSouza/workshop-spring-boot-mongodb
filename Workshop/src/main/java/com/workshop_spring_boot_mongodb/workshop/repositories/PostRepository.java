package com.workshop_spring_boot_mongodb.workshop.repositories;

import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String title);

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String title);

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title' : { $regex: ?0, $options: 'i' } }, { 'body' : { $regex: ?0, $options: 'i' } }, { 'comments.text' : { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String title, Date minDate, Date maxDate);
}
