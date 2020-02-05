package com.valensmarcos.service;

import com.valensmarcos.model.User;

import java.util.List;

public interface UserQueryService {

    List<User> findAll();

    User findById(long id);

    User validation(String userName, String password);

    User findByUserNameAndId(String userName, String id);
}
