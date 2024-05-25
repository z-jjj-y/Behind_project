package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> getAllUsers();
    User getUserById(int userId);
    void updateUser(User user);
    void deleteUser(int userId);
    User login(String account, String password);
    User register(User user);
}
