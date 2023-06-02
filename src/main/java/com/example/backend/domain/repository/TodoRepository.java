package com.example.backend.domain.repository;

import com.example.backend.domain.model.Todo;

/**
 * TodoのRepositoryインタフェース
 */
public interface TodoRepository {
    /**
     * Todoを作成する
     * 
     * @param todo 作成するTodo
     * @return 登録結果
     * 
     */
    boolean insert(Todo todo);

    /**
     * Todoを取得する
     * 
     * @param todoId Todo ID
     * @return Todo
     */
    Todo findById(String todoId);

}
