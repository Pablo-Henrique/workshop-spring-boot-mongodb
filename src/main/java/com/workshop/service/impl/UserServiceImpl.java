package com.workshop.service.impl;

import com.workshop.handler.exception.ResourceNotFoundException;
import com.workshop.model.User;
import com.workshop.repository.UserRepository;
import com.workshop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public User insert(User user) {
        return repository.insert(user);
    }

    @Override
    public void delete(String id) {
        repository.delete(findById(id));
    }

    @Override
    public User update(String id, User user) {
        User updatedUser = findById(id);
        BeanUtils.copyProperties(user, updatedUser, "id");
        return repository.save(updatedUser);
    }
}
