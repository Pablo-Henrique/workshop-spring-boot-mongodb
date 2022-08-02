package com.workshop.service.impl;

import com.workshop.handler.exception.ResourceNotFoundException;
import com.workshop.model.Post;
import com.workshop.repository.PostRepository;
import com.workshop.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Post insert(Post post) {
        return repository.insert(post);
    }

    @Override
    public void delete(String id) {
        repository.delete(findById(id));
    }

    @Override
    public Post update(String id, Post post) {
        Post updatedPost = findById(id);
        BeanUtils.copyProperties(post, updatedPost, "id");
        return repository.save(updatedPost);
    }
}
