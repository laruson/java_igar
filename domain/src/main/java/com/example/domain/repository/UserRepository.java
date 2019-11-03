package com.example.domain.repository;

import com.example.domain.entity.user.User;

import io.reactivex.Observable;

public interface UserRepository {
    Observable<User> getUser(int id);
}
