package com.example.data.repository;

import com.example.data.rest.service.Service;
import com.example.domain.entity.Post;
import com.example.domain.repository.PostRepository;

import java.util.List;

import io.reactivex.Observable;

public class PostRepositoryImpl implements PostRepository {
    private Service service;

    public PostRepositoryImpl(Service service) {
        this.service = service;
    }

    @Override
    public Observable<List<Post>> getPost() {
        return service.getPosts();
    }
}
