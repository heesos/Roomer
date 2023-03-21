package com.roomer.app.service;

import com.roomer.app.domain.User;
import com.roomer.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public long saveUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
