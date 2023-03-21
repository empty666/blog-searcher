package com.empty.searcher.common.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class LocalRedisConfig {

    @Value("${spring.redis.port}")
    private int port;

    private RedisServer redisServer;

    @PostConstruct
    void startRedis() {
        this.redisServer = new RedisServer(port);
        this.redisServer.start();
    }

    @PreDestroy
    void stopRedis() {
        this.redisServer.stop();
    }
}
