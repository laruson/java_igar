package com.example.data.repository;

import com.example.data.rest.service.Service;
import com.example.domain.entity.user.User;
import com.example.domain.repository.UserRepository;

import io.reactivex.Observable;

public class UserRepositoryImpl implements UserRepository {
    private Service service;

    @Override
    public Observable<User> getUser(int id) {
        return service.getUser(id);
    }
}
