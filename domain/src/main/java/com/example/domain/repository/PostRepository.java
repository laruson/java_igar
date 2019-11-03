package com.example.domain.repository;

import com.example.domain.entity.Post;

import java.util.List;

import io.reactivex.Observable;

public interface PostRepository {
    Observable<List<Post>> getPost();
}
