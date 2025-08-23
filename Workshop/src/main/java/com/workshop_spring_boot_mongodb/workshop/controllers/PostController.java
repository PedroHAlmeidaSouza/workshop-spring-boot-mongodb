package com.workshop_spring_boot_mongodb.workshop.controllers;

import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import com.workshop_spring_boot_mongodb.workshop.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post obj = postService.findById(id);
        return ResponseEntity.ok(obj);
    }
}
