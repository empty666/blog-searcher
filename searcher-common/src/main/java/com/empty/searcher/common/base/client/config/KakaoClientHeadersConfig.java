package com.empty.searcher.common.base.client.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//@PropertySource("classpath:com.empty.search.")
public class KakaoClientHeadersConfig {

    @Value("${blog-searcher.client.rest-api-key.kakao}")
    private  String token;

    @Bean
    public RequestInterceptor feignRequestInterceptor() {
        return requestTemplate -> requestTemplate.header("Authorization", String.format("KakaoAK %s", token));
    }
}
