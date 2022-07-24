package com.workshop.controller;

import com.workshop.dto.UserDTO;
import com.workshop.model.User;
import com.workshop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usersDTO = new ArrayList<>();
        BeanUtils.copyProperties(service.findAll(), usersDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usersDTO);
    }

}
