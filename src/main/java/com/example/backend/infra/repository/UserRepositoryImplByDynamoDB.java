package com.example.backend.infra.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.backend.domain.model.User;
import com.example.backend.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;
//import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
//import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import static software.amazon.awssdk.enhanced.dynamodb.mapper.StaticAttributeTags.primaryPartitionKey;

/**
 * DynamoDBにアクセスするUserRepository実装クラス
 */
//@XRayEnabled
//MyBatis版に置き換えたため未使用
@Repository
@RequiredArgsConstructor
public class UserRepositoryImplByDynamoDB implements UserRepository {
    private final DynamoDbEnhancedClient enhancedClient;
    //private final DynamoDbEnhancedAsyncClient enhancedClient;
    private final UserTableItemMapper userTableItemMapper;

    @Value("${aws.dynamodb.user-tablename}")
    private String userTableName;

    // （参考）DynamoDbEnhancedClientの実装例
    // https://docs.aws.amazon.com/ja_jp/sdk-for-java/latest/developer-guide/examples-dynamodb-enhanced.html
    // https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code/dynamodb/src/main/java/com/example/dynamodb
    

    @Override
    public boolean insert(User user) {
        // user.setUserId(UUID.randomUUID().toString());
        UserTableItem userItem = userTableItemMapper.modelToTableItem(user);
        DynamoDbTable<UserTableItem> dynamoDb = createDynamoDBClient();
        dynamoDb.putItem(userItem);
        //DynamoDbAsyncTable<UserTableItem> dynamoDb = createDynamoDBClient();
        //dynamoDb.putItem(userItem).join();        
        return true;
    }

    @Override
    public User findOne(String userId) {
        DynamoDbTable<UserTableItem> dynamoDb = createDynamoDBClient();
        //DynamoDbAsyncTable<UserTableItem> dynamoDb = createDynamoDBClient();
        Key key = Key.builder().partitionValue(userId).build();
        UserTableItem userItem = dynamoDb.getItem(r -> r.key(key));
        
        //UserTableItem userItem = dynamoDb.getItem(r -> r.key(key)).join();
        return userTableItemMapper.tableItemToModel(userItem);
        
    }

    
    private DynamoDbTable<UserTableItem> createDynamoDBClient() {
    //private DynamoDbAsyncTable<UserTableItem> createDynamoDBClient() {
                
        //return enhancedClient.table(userTableName, TableSchema.fromBean(UserTableItem.class));

        //TODO: GraalVMだと、DynamoDbEnhancedClientのTableSchema.fromBeanが動作しない
        //https://github.com/oracle/graal/issues/3386
        //回避策としてビルダーを使ってスキーマ定義
        TableSchema<UserTableItem> tableSchema = TableSchema.builder(UserTableItem.class)
                .newItemSupplier(UserTableItem::new)
                .addAttribute(String.class, a -> a.name("user_id")
                        .getter(UserTableItem::getUserId)
                        .setter(UserTableItem::setUserId)
                        .tags(primaryPartitionKey()))
                .addAttribute(String.class, a -> a.name("name")
                        .getter(UserTableItem::getName)
                        .setter(UserTableItem::setName))                        
                .build();
        
        
        return enhancedClient.table(userTableName, tableSchema);
    }
}
