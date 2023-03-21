package com.empty.searcher.api.blog.service;

import com.empty.searcher.common.base.event.AppEventPublisher;
import com.empty.searcher.common.domain.keyword.entity.RecentKeyword;
import com.empty.searcher.common.domain.keyword.event.RecentKeywordHitEvent;
import com.empty.searcher.common.domain.keyword.repository.RecentKeywordRepository;
import com.empty.searcher.common.domain.keyword.service.RecentKeywordService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BlogSearchApplicationTest {

    @Autowired
    private AppEventPublisher eventPublisher;

    @Autowired
    private RecentKeywordRepository keywordRepository;

    @Autowired
    private RecentKeywordService keywordService;

    @AfterEach
    public void after() {
        keywordRepository.deleteAll();
    }

    @Test
    public void 동시_조회수_증가_요청_테스트() throws InterruptedException {
        int threadCount = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(32);

        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {

                try {
                    eventPublisher.send(new RecentKeywordHitEvent(List.of("multiple_test")));
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        RecentKeyword recentKeyword = keywordRepository.findById("multiple_test").orElseThrow();
        assertThat(recentKeyword.getHitCount()).isEqualTo(1000L);
    }
}
