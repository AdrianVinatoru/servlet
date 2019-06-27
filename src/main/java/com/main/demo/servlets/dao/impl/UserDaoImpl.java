package com.main.demo.servlets.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.main.demo.servlets.config.DbConnection;
import com.main.demo.servlets.dao.UserDao;
import com.main.demo.servlets.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAllUsers() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM public.users";
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = createUserFrom(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not execute statement", e);
        } finally {
            DbConnection.closeConnection(connection);
        }

        return users;
    }

    @Override
    public User getUserById(Integer id) {
        Connection connection = null;
        User user = null;
        String query = String.format("SELECT * FROM public.users WHERE id = %s;", id);

        try {
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                user = createUserFrom(resultSet);
            }
        }catch (SQLException e){
            throw new RuntimeException("Could not execute statement", e);
        }

        return user;
    }

    private User createUserFrom(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String phoneNumber = resultSet.getString("phone_number");
        return new User(id, name, phoneNumber);
    }

    @Override
    public void saveUser(User user) {
        Connection connection = null;

        try {
            String query = String
                    .format("INSERT INTO public.users(id,name,phone_number) VALUES ('%s','%s', '%s');",
                            user.getId(), user.getName(), user.getPhoneNumber());
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException("Could not save user", e);
        } finally {
            DbConnection.closeConnection(connection);
        }
    }

    @Override
    public User updateUser(User user) {
        Connection connection = null;

        try {
            String UPDATE_SQL = "UPDATE user SET id=?, name=?, phone_number=? WHERE id=?";
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(UPDATE_SQL);


        } catch (SQLException e) {
            throw new RuntimeException("Could not update user", e);
        } finally {
            DbConnection.closeConnection(connection);
        }

        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        Connection connection = null;

        try {
            String DELETE_SQL = String
                    .format("DELETE FROM public.users WHERE id = %s", userId);
            connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(DELETE_SQL);
        } catch (SQLException e) {
            throw new RuntimeException("Could not delete user", e);
        } finally {
            DbConnection.closeConnection(connection);
        }
    }
}
