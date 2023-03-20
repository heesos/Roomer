package com.roomer.app.controller;

import com.roomer.app.domain.User;
import com.roomer.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
public class UserController {
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
