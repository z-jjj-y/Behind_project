package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.mapper.UserMapper;
import com.gui.ydd.entity.User;
import com.gui.ydd.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public List<User> getAllUsers() {
        return list();
    }

    @Override
    public User getUserById(int userId) {
        return lambdaQuery().eq(User::getUserId, userId).one();
    }

    @Override
    public User register(User user) {
        boolean insertResult = save(user);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert user record");
        }else{
            System.out.println("Successfully inserted user record");
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        boolean updateResult = updateById(user);
        if (!updateResult) {
            throw new RuntimeException("Failed to update user record");
        }else{
            System.out.println("Successfully updated user record");
        }
    }

    @Override
    public void deleteUser(int userId) {
        boolean deleteResult = removeById(userId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete user record");
        }else{
            System.out.println("Successfully deleted user record");
        }
    }

    @Override
    public User login(String account, String password,String role) {
        return lambdaQuery().eq(User::getAccount, account).eq(User::getPassword, password).eq(User::getRole, role).one();
    }

}
