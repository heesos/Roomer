package com.roomer.app.service;

import com.roomer.app.domain.User;
import com.roomer.app.exception.UserNotFoundException;
import com.roomer.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * tests created using AAA pattern (Arrange/Act/Assert)
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;
    User user = User.builder()
            .age(0)
            .id(1)
            .name("TestName")
            .description("Test Description")
            .dateOfBirth(LocalDate.now())
            .build();

    @Test
    void saveUser() {
        //Arrange
        when(userRepository.save(any())).thenReturn(user);

        //Act
        User newUser = userService.saveUser(User.builder().build());

        //Assert
        Assertions.assertEquals(newUser, user);
    }

    @Test
    void getListOfAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user, user));

        List<User> userArrayList = userService.getAllUsers();

        Assertions.assertEquals(userArrayList, List.of(user, user));
    }

    @Test
    void getUserById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(user));

        User newUser = userService.getUserById(anyLong());

        Assertions.assertEquals(newUser, user);
    }

    @Test
    void updateUser() {
        User newUser = User.builder()
                .name("newName").description("new Description").build();
        User updatedUser = User.builder()
                .age(0).name("newName").description("new Description").id(1).dateOfBirth(LocalDate.now()).build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(user));
        when(userRepository.save(user)).thenReturn(user);

        User userAfterUpdate = userService.updateUser(anyLong(), newUser);

        Assertions.assertEquals(updatedUser, userAfterUpdate);
    }

    @Test
    public void testRemoveUserById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById(anyLong());

        userService.removeUserById(anyLong());

        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void getUserByIdThrowsExceptionTest() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        Throwable throwable = Assertions.assertThrows(UserNotFoundException.class, () -> userService.getUserById(anyLong()));

        Assertions.assertEquals("User with id: 0 not found.", throwable.getMessage());
    }

    @Test
    public void deleteUserThrowsException() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        Throwable throwable = Assertions.assertThrows(UserNotFoundException.class, () -> userService.removeUserById(anyLong()));

        Assertions.assertEquals("User with id: 0 not found. Couldn't delete", throwable.getMessage());
    }

    @Test
    public void updateUserThrowsException() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        Throwable throwable = Assertions.assertThrows(UserNotFoundException.class, () -> userService.updateUser(anyLong(), user));

        Assertions.assertEquals("User with id: 0 not found. Couldn't update.", throwable.getMessage());
    }
}
