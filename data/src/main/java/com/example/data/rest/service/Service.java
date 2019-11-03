package com.example.data.rest.service;

import com.example.data.rest.api.PostApi;
import com.example.data.rest.api.UserApi;
import com.example.domain.entity.Post;
import com.example.domain.entity.user.User;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private UserApi userApi;
    private PostApi postApi;

    public Service() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS);

        GsonBuilder gson = new GsonBuilder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson.create()))
                .client(okHttpBuilder.build())
                .build();

        userApi = retrofit.create(UserApi.class);
        postApi = retrofit.create(PostApi.class);
    }

    public Observable<User> getUser(int id) {
        return userApi.getUser(id);
    }

    public Observable<List<Post>> getPosts() {
        return postApi.getPosts();
    }
}
