package com.example.data.rest.api;

import com.example.domain.entity.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostApi {

    @GET("/posts")
    Observable<List<Post>> getPosts();
}
