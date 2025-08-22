package com.workshop_spring_boot_mongodb.workshop.services;

import com.workshop_spring_boot_mongodb.workshop.entities.User;
import com.workshop_spring_boot_mongodb.workshop.repositories.UserRepository;
import com.workshop_spring_boot_mongodb.workshop.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
