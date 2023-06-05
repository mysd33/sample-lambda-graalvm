package com.example.backend.infra.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * DynamoDBのUserテーブルItemクラス
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class UserTableItem {
    // ID
    private String userId;
    // タイトル
    private String name;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("user_id")
    public String getUserId() {
        return userId;
    }

}