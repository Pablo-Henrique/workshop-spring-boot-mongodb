package com.workshop.service;

import com.workshop.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User insert(User user);

    void delete(String id);
}
