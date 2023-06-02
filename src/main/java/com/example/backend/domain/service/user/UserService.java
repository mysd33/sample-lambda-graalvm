package com.example.backend.domain.service.user;

import com.example.backend.domain.model.User;



/**
 * 
 * ユーザ管理機能のサービスインタフェース
 *
 */
public interface UserService {

    /**
     * ユーザを作成する
     * 
     * @param user ユーザ
     * @return 作成したユーザ
     */
    User create(User user);

    /**
     * ユーザ取得
     * 
     * @param userId ユーザID
     * @return ユーザ
     * 
     */
    User findOne(String userId);


}