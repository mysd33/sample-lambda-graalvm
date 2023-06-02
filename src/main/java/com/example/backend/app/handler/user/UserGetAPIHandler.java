package com.example.backend.app.handler.user;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.backend.app.handler.common.APIUtil;
import com.example.backend.domain.model.User;
import com.example.backend.domain.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

/**
 * Spring Cloud FunctionによるユーザサービスのGet APIハンドラクラス
 *
 */
@Component
@RequiredArgsConstructor
public class UserGetAPIHandler implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final UserService userService;
    private final UserResourceMapper userResourceMapper;
    private final ObjectMapper objectMapper;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {       
        String userId = request.getPathParameters().get("user_id");
        // サービスの実行
        User user = userService.findOne(userId);
        UserResource result = userResourceMapper.modelToResource(user);
        return APIUtil.createAPIGwResponse(objectMapper, result);
    }

}
