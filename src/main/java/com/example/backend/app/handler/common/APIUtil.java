package com.example.backend.app.handler.common;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: フレームワーク化
/**
 * 
 * APIレスポンス作成のための仮のユーティリティクラス
 *
 */
public final class APIUtil {
    private APIUtil() {
    }

    public static APIGatewayProxyResponseEvent createAPIGwResponse(final ObjectMapper objectMapper, final Object result) {
        String message;
        try {
            message = objectMapper.writeValueAsString(result);
            return createAPIGwResponse(200, message);
        } catch (JsonProcessingException e) {
            // TODO: 仮の例外処理
            return createAPIGwResponse(500, e.getMessage());
        }
    }

    public static APIGatewayProxyResponseEvent createAPIGwResponse(Integer statusCode, String message) {
        return new APIGatewayProxyResponseEvent().withStatusCode(statusCode).withBody(String.format("%s%n", message));
    }

}
