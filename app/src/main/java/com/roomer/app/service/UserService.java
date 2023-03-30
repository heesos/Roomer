package com.roomer.app.service;

import com.roomer.app.domain.User;
import com.roomer.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for business logic when performing database operations with User entity
 *
 * @author milosz.marzec
 */
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    /**
     * Saves a new User to the database
     *
     * @param user User entity
     * @return created User in database
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Searches for all Users in database
     *
     * @return list of Users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Removes User from database
     *
     * @param id id of User to remove
     */

    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    /**
     * Gets User from database by id
     *
     * @param id User id
     * @return User object
     */
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing User in the database
     *
     * @param userId  id used to search User to update
     * @param newUser User with the new data
     * @return id of an updated User object
     */
    public User updateUser(long userId, User newUser) {
        User userToUpdate = userRepository.findById(userId).orElse(null);

        if (newUser.getName() != null) {
            userToUpdate.setName(newUser.getName());
        }
        if (newUser.getDescription() != null) {
            userToUpdate.setDescription(newUser.getDescription());
        }
        if (newUser.getDateOfBirth() != null) {
            userToUpdate.setDateOfBirth(newUser.getDateOfBirth());
        }

        return userRepository.save(userToUpdate);
    }
}
