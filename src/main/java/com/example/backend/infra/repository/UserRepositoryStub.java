package com.example.backend.infra.repository;

import org.springframework.stereotype.Repository;

import com.example.backend.domain.model.User;
import com.example.backend.domain.repository.UserRepository;

//@Repository
public class UserRepositoryStub implements UserRepository {

    @Override
    public boolean insert(User user) {
        return true;
    }

    @Override
    public User findOne(String userId) {
        return User.builder().userId(userId).name("dummy").build();
    }

}
