package com.workshop.controller;

import com.workshop.model.Post;
import com.workshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(path = "/post/{id}")
    public ResponseEntity<Post> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

}
