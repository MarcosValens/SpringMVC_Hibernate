package com.valensmarcos.service;

import com.valensmarcos.dao.UserDao;
import com.valensmarcos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserQueryService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {

        return userDao.findById(id);
    }

    @Override
    public User validation(String userName, String password) {

        return userDao.isValidUser(userName, password);
    }
}
