package com.valensmarcos.dao;

import com.valensmarcos.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    List<User> findAll();

    void insert(User user);

    void edit(User user);

    void delete(int id);

    User isValidUser(String userName, String password);

    User findByUserNameAndId(String userName, String id);
}