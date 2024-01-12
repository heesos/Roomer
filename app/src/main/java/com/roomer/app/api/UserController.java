package com.roomer.app.api;

import com.roomer.app.domain.User;
import com.roomer.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for User entity
 * @author milosz.marzec
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {
    private UserService userService;

    /**
     * Creates a new user
     * @param user user object with all the information
     * @return HTTP response with new created User
     */
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    /**
     * Fetches a list of Users from database
     * @return list of Users
     */
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    /**
     * Fetches User from database by id
     * @param id id of user to be found
     * @return User object
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Deletes a User from database
     * @param id id of a User to delete
     * @return HTTP Status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates an existing User
     * @param user User with new data
     * @param id id of a User to update
     * @return User object with new data which was saved to database
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
