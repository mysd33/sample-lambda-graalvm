package com.example.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.fw.common.aspect.XRayAspect;
import com.example.fw.common.jdbc.config.XRayJDBCConfig;


/**
 * X-Rayの設定クラス
 *
 */
// JDBCのX-Rayトレース機能の追加
@Import({ XRayJDBCConfig.class })
@Configuration
public class XRayConfig {

    /**
     * AWS X-RayのAOP設定
     */
    @Bean
    public XRayAspect xRayAspect() {
        return new XRayAspect();
    }
}
