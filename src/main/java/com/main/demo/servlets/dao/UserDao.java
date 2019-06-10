package com.main.demo.servlets.dao;

import com.main.demo.servlets.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUsers();

    User getUserById(Integer id);

    void saveUser(User user);

    User updateUser(User user);

    void deleteUser(Integer userId);


}
