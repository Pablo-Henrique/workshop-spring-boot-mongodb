package com.workshop.service;

import com.workshop.model.Post;

import java.util.Date;
import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post findById(String id);

    Post insert(Post user);

    void delete(String id);

    Post update(String id, Post updatedPost);

    List<Post> findByTitleContainingIgnoreCase(String title);

    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
