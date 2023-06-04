package com.example.backend.infra.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.backend.domain.model.Todo;
import com.example.backend.domain.repository.TodoRepository;

@Repository
public class TodoRepositoryStub implements TodoRepository {

    @Override
    public boolean insert(Todo todo) {
        todo.setTitle(UUID.randomUUID().toString());
        
        return true;
    }

    @Override
    public Todo findById(String todoId) {        
        return Todo.builder().todoId(todoId).title("dummy").build();
    }

}
