package com.empty.searcher.common.base.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RedisLockRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public Boolean lock(final String key) {
        return redisTemplate
            .opsForValue()
            .setIfAbsent(key, "lock", Duration.ofMillis(3_000));
    }

    public Boolean unlock(final String key) {
        return redisTemplate.delete(key);
    }

}
