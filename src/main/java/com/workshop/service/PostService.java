package com.workshop.service;

import com.workshop.model.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(String id);

    Post insert(Post user);

    void delete(String id);

    Post update(String id, Post updatedPost);
}
