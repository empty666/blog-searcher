package com.empty.searcher.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.empty.searcher.common.*")
public class BlogSearcherCommonConfig {

}
