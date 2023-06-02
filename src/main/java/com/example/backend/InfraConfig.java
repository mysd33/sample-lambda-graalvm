package com.example.backend;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.fw.common.dynamodb.config.DynamoDBConfigPackage;

/**
 * 
 * インフラストラクチャ層の設定クラス
 *
 */
@Configuration
@ComponentScan(basePackageClasses = { DynamoDBConfigPackage.class })
public class InfraConfig {

}
