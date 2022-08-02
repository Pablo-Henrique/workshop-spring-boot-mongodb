package com.workshop.controller;

import com.workshop.dto.AuthorDTO;
import com.workshop.dto.UserDTO;
import com.workshop.mapper.PostMapper;
import com.workshop.mapper.UserMapper;
import com.workshop.model.Post;
import com.workshop.model.User;
import com.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.converterListEntityToDTO(service.findAll()));
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") String id){
        UserDTO response = userMapper.converterEntityToDTO(service.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/user/{id}/posts")
    public ResponseEntity<List<Post>> findAllPosts(@PathVariable(value = "id") String id){
        User user = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.getPosts());
    }

    @PostMapping(path = "/user")
    public ResponseEntity<URI> insert(@RequestBody UserDTO userDTO) {
        User user = service.insert(userMapper.converterDtoToEntity(userDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(uri);
    }

    @DeleteMapping(path = "/user/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/user/update/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable(value = "id") String id,@RequestBody UserDTO userDTO) {
        User user = service.update(id, userMapper.converterDtoToEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.converterEntityToDTO(user));
    }

}
