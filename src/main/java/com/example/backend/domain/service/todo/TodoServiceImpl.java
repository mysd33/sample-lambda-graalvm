package com.example.backend.domain.service.todo;

import org.springframework.stereotype.Service;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.backend.domain.model.Todo;
import com.example.backend.domain.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

/**
 * TodoServiceの実装クラス
 *
 */
@XRayEnabled
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    
    @Override
    public Todo create(Todo todo) {
        todoRepository.insert(todo);        
        return todo;
    }

    @Override
    public Todo findOne(String todoId) {
        return todoRepository.findById(todoId);
    }
}
