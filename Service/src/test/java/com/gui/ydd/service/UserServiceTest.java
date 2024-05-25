package com.gui.ydd.service;

import com.gui.ydd.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers() {
        assertNotNull(userService.getAllUsers(), "Users list should not be null");
    }

    @Test
    void getUserById() {
        User user = userService.getUserById(1); // Assuming a user with id 1 exists
        assertNotNull(user, "User should not be null");
    }

    @Test
    void createUser() {
        User user = new User.Builder()
                .account("test")
                .username("test")
                .password("test")
                .role("admin")
                .createdate(null)
                .build();
        userService.register(user);
        assertNotNull(userService.getUserById(1), "User should not be null");
    }

    @Test
    void updateUser() {
        User user = userService.getUserById(1); // Assuming a user with id 1 exists
        user.setUsername("test");
        userService.updateUser(user);
        assertEquals("test", userService.getUserById(1).getUsername(), "Username should be updated");
    }

    @Test
    void deleteUser() {
        userService.deleteUser(7); // Assuming a user with id 1 exists
        assertNull(userService.getUserById(7), "User should be deleted");
    }
}