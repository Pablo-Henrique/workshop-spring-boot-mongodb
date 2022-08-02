package com.workshop.controller;

import com.workshop.model.Post;
import com.workshop.service.PostService;
import com.workshop.util.DecoderURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(path = "/post/{id}")
    public ResponseEntity<Post> findById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping(path = "/post/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByTitleContainingIgnoreCase(DecoderURL.urlDecoder(title)));
    }

}
