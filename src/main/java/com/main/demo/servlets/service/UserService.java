package com.main.demo.servlets.service;

import com.main.demo.servlets.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAllUsers();

    User findUserById(Integer id);

    void deleteUser(User user);

    int totalUsers();
}
