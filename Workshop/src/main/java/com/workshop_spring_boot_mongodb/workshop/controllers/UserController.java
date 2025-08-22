package com.workshop_spring_boot_mongodb.workshop.controllers;

import com.workshop_spring_boot_mongodb.workshop.dto.UserDTO;
import com.workshop_spring_boot_mongodb.workshop.entities.User;
import com.workshop_spring_boot_mongodb.workshop.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = userService.findAll();

        List<UserDTO> listDTO = list.stream().map(UserDTO::new).toList();

        return ResponseEntity.ok(listDTO);
    }
}
