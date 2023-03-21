package com.empty.searcher.common.domain.keyword.event.listener;

import com.empty.searcher.common.base.redis.RedisLockRepository;
import com.empty.searcher.common.domain.keyword.event.RecentKeywordHitEvent;
import com.empty.searcher.common.domain.keyword.service.RecentKeywordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RecentKeywordEventListener {

    private final RedisLockRepository redisLockRepository;
    private final RecentKeywordService keywordService;

    public void increaseHitCountByKeyword(String keyword) throws InterruptedException{
        while (! redisLockRepository.lock(keyword)) {
            Thread.sleep(100);
        }

        try {
            keywordService.increaseHitCountByKeyword(keyword);
        } finally {
            redisLockRepository.unlock(keyword);
        }

    }

    @EventListener
    public void on(RecentKeywordHitEvent event) {
        log.info("Event Listener : {}", event.getKeywords());
        event.getKeywords().forEach(item -> {
            try {
                this.increaseHitCountByKeyword(item);
            } catch (InterruptedException ex) {
                log.error("Update Hit Count : {}", item);
                log.error(ex.getMessage());
            }

        });

    }
}
