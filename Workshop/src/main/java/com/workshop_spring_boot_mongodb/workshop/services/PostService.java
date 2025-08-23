package com.workshop_spring_boot_mongodb.workshop.services;

import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import com.workshop_spring_boot_mongodb.workshop.repositories.PostRepository;
import com.workshop_spring_boot_mongodb.workshop.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
