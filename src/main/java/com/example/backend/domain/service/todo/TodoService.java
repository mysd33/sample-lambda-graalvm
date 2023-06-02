package com.example.backend.domain.service.todo;

import com.example.backend.domain.model.Todo;

/**
 * 
 * Todo機能のサービスインタフェース
 *
 */
public interface TodoService {
    /**
     * Todoを作成する
     * 
     * @param todo 作成するTodo
     * @return 作成したTodo
     */
    Todo create(Todo todo);

    /**
     * Todoを取得する
     * 
     * @param todoId todoID
     * @return Todo
     */
    Todo findOne(String todoId);


}
