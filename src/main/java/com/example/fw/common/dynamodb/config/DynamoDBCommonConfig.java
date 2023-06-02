package com.example.fw.common.dynamodb.config;

import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
//import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/**
 * DynamoDBの共通の設定クラス
 *
 */
@Configuration
public class DynamoDBCommonConfig {
    /*
	@Autowired
	private DynamoDbClient dynamoDbClient;
	*/

    @Autowired
    private DynamoDbAsyncClient dynamoDbClient;

	/**
	 * DynamoDBEnhancedClient
	 * 
	 */
    /*
	@Bean
	public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
		return DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build();
	}
	*/
    
    /**
     * DynamoDBEnhancedAsyncClient
     */
    @Bean
    public DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient(DynamoDbAsyncClient dynamoDbClient) {
        // https://docs.aws.amazon.com/ja_jp/sdk-for-java/latest/developer-guide/ddb-en-client-getting-started-dynamodbTable.html
        return DynamoDbEnhancedAsyncClient.builder().dynamoDbClient(dynamoDbClient).build();
    }

	
	@PreDestroy
	public void closeDynamoDBClient() {
		dynamoDbClient.close();
	}
	
}
