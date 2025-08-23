package com.workshop_spring_boot_mongodb.workshop.controllers;

import com.workshop_spring_boot_mongodb.workshop.controllers.util.URL;
import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import com.workshop_spring_boot_mongodb.workshop.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

        text = URL.decodeParam(text);
        List<Post> obj = postService.findByTitle(text);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> obj = postService.fullSearch(text, min, max);
        return ResponseEntity.ok(obj);
    }
}
