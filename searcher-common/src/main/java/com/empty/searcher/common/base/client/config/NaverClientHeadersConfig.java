package com.empty.searcher.common.base.client.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class NaverClientHeadersConfig {
    @Value("${blog-searcher.client.rest-api-key.naver}")
    private  String token;

    @Value("${blog-searcher.client.client-id.naver}")
    private String clientId;

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Naver-Client-Id", clientId);
            requestTemplate.header("X-Naver-Client-Secret", token);
        };
    }
}
