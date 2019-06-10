package com.main.demo.servlets.service.impl;

import com.main.demo.servlets.dao.UserDao;
import com.main.demo.servlets.dao.impl.UserDaoImpl;
import com.main.demo.servlets.model.User;
import com.main.demo.servlets.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
        List<User> findAllUsers=userDao.findAllUsers();
    }

    @Override
    public List<User> findAllUsers() {
        //@todoL:implementation will follow
        return null;
    }
}
