package com.valensmarcos.dao;

import com.valensmarcos.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    List<User> findAll();

    User isValidUser(String userName, String password);
}