package com.example.backend.infra.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * DynamoDBのTodoテーブルItemクラス
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class TodoTableItem {
    // ID    
    private String todoId;

    // タイトル
    private String title;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("todo_id")
    public String getTodoId() {
        return todoId;
    }

}