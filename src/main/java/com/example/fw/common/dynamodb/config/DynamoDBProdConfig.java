package com.example.fw.common.dynamodb.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.xray.interceptors.TracingInterceptor;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/**
 * DynamoDB 本番用の設定クラス
 *
 */
@Configuration
@EnableConfigurationProperties(DynamoDBConfigurationProperties.class)
public class DynamoDBProdConfig {

    /**
     * DynamoDB Localに接続するDynamoDBClient
     */
    /*
    @Bean
    public DynamoDbClient dynamoDbClient(DynamoDBConfigurationProperties dynamoDBConfigurationProperties) {
        Region region = Region.of(dynamoDBConfigurationProperties.getRegion());
        return DynamoDbClient.builder().region(region)
                // 個別にDynamoDBへのAWS SDKの呼び出しをトレーシングできるように設定
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder().addExecutionInterceptor(new TracingInterceptor()).build())
                .build();
    }*/

    /**
     * DynamoDB Localに接続するDynamoDBAyncClient
     */
    @Bean
    public DynamoDbAsyncClient dynamoDbAsyncClient(DynamoDBConfigurationProperties dynamoDBConfigurationProperties) {
        Region region = Region.of(dynamoDBConfigurationProperties.getRegion());
        return DynamoDbAsyncClient.builder().region(region)
                // 個別にDynamoDBへのAWS SDKの呼び出しをトレーシングできるように設定
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder().addExecutionInterceptor(new TracingInterceptor()).build())
                // CRT Clientを設定
                .httpClientBuilder(AwsCrtAsyncHttpClient.builder())
                .build();
    }

}
