package com.workshop_spring_boot_mongodb.workshop.services;

import com.workshop_spring_boot_mongodb.workshop.dto.UserDTO;
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

    public User save(User obj) {
        return userRepository.save(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
