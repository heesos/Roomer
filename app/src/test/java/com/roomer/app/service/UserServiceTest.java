package com.roomer.app.service;

import com.roomer.app.domain.User;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
        when(userRepository.save(any())).thenReturn(user);

        User newUser = userService.saveUser(User.builder().build());

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
        System.out.println(userAfterUpdate);

        Assertions.assertEquals(updatedUser, userAfterUpdate);
    }

    @Test
    public void testRemoveUserById() {
        doNothing().when(userRepository).deleteById(anyLong());

        userService.removeUserById(anyLong());

        verify(userRepository, times(1)).deleteById(anyLong());
    }

}
