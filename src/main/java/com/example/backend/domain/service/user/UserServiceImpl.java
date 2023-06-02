package com.example.backend.domain.service.user;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.backend.domain.model.User;
import com.example.backend.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;


/**
 * UserServiceの実装クラス
 *
 */
@XRayEnabled
@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    
    @Override
    public User create(User user) {
        user.setUserId(UUID.randomUUID().toString());
        userRepository.insert(user);        
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }
}
