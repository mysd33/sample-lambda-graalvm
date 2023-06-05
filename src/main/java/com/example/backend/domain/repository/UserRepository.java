package com.example.backend.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.backend.domain.model.User;

/**
 * 
 * ユーザリポジトリインタフェース 
 *
 */
//MyBatisにより実現
@Mapper
public interface UserRepository {
    /**
     * ユーザを登録する
     * 
     * @param user ユーザ情報
     * @return 登録結果
     */
    public boolean insert(User user);
   
    /**
     * ユーザを取得する
     * 
     * @param userId ユーザID
     * @return ユーザ情報
     * 
     */
    public User findOne(String userId);
    

}
