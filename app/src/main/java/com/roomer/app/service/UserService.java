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
        userRepository.save(user);
        return user;
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
        return userRepository.getReferenceById(id);
    }

    /**
     * Updates an existing User in the database
     *
     * @param userId  id used to search User to update
     * @param newUser User with the new data
     * @return id of an updated User object
     */
    public long updateUser(long userId, User newUser) {
        User userToUpdate = userRepository.getReferenceById(userId);
        userToUpdate.setName(newUser.getName());
        userToUpdate.setDescription(newUser.getDescription());
        userToUpdate.setDateOfBirth(newUser.getDateOfBirth());

        userRepository.save(userToUpdate);

        return userId;
    }
}
