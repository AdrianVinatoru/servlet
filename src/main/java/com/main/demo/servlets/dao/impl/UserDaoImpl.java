package com.main.demo.servlets.dao.impl;

import com.main.demo.servlets.config.DbConnection;
import com.main.demo.servlets.dao.UserDao;
import com.main.demo.servlets.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAllUsers() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            String query = "Select * from public.users";
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");

                User user = new User(id, name, phoneNumber);

                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not  execute statement", e);
        } finally {
            DbConnection.closeConnection(connection);
        }

        return users;
    }

    @Override
    public User getUserById(Integer id) {
        //@todo:implementation will follow
        return null;
    }

    @Override
    public void saveUser(User user) {
        try {
            String query = String
                    .format("INSERT INTO public.users(id,name,phone_number) VALUES ('%s','%s', '%s');", user.getId(), user.getName(), user.getPhoneNumber());
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException("Could not  execute statement", e);
        }
    }

    @Override
    public User updateUser(User user) {
        //@todo:implementation will follow
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        //@todo:implementation will follow
    }
}
