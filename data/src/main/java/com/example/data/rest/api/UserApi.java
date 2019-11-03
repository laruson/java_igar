package com.example.data.rest.api;

import com.example.domain.entity.user.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {

    @GET("/users/{id}")
    Observable<User> getUser(@Path("id") int id);
}
