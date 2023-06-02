package com.example.backend.app.handler.user;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.backend.app.handler.common.APIUtil;
import com.example.backend.domain.model.User;
import com.example.backend.domain.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/**
 * Spring Cloud FunctionによるTodoサービスのGet APIハンドラクラス
 *
 */
@Component
@RequiredArgsConstructor
public class UserPostAPIHandler implements Function<UserResource, APIGatewayProxyResponseEvent> {
    private final UserService userService;
    private final UserResourceMapper userResourceMapper;
    private final ObjectMapper objectMapper;

    @Override
    public APIGatewayProxyResponseEvent apply(UserResource resource) {                
        User user = userResourceMapper.resourceToModel(resource);
        // サービスの実行
        User newUser = userService.create(user);
        UserResource result = userResourceMapper.modelToResource(newUser);
        return APIUtil.createAPIGwResponse(objectMapper, result);
    }

}
