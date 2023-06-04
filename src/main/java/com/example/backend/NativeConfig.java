package com.example.backend;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

import com.example.backend.app.handler.todo.TodoResource;
import com.example.backend.app.handler.user.UserResource;
import com.example.backend.domain.model.Todo;
import com.example.backend.domain.model.User;

/**
 * GraalVM向けにリフレクションのヒントを与えるため設定クラス
 *
 */
@Configuration
@RegisterReflectionForBinding({
    UserResource.class,
    TodoResource.class,
    User.class,
    Todo.class
})
public class NativeConfig {    
}
