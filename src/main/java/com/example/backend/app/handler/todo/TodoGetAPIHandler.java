package com.example.backend.app.handler.todo;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.backend.app.handler.common.APIUtil;
import com.example.backend.domain.model.Todo;
import com.example.backend.domain.service.todo.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/**
 * Spring Cloud FunctionによるTodoサービスのGet APIハンドラクラス
 *
 */
@Component
@RequiredArgsConstructor
public class TodoGetAPIHandler implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final TodoService todoService;
    private final TodoResourceMapper todoResourceMapper;
    private final ObjectMapper objectMapper;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
       
        String todoId = request.getPathParameters().get("todo_id");
        // サービスの実行
        Todo todo = todoService.findOne(todoId);
        TodoResource result = todoResourceMapper.modelToResource(todo);        
        return APIUtil.createAPIGwResponse(objectMapper, result);
    }

    

}
