package com.valensmarcos.service;

import com.valensmarcos.model.User;

import java.util.List;

public interface UserQueryService {

    List<User> findAll();

    User findById(int id);

    User validation(String userName, String password);

}
