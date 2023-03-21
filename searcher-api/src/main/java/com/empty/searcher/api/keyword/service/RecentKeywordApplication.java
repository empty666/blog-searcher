package com.empty.searcher.api.keyword.service;

import com.empty.searcher.api.keyword.dto.RecentKeywordResponseDto;
import com.empty.searcher.common.base.redis.RedisLockRepository;
import com.empty.searcher.common.domain.keyword.service.RecentKeywordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class RecentKeywordApplication {

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

    public RecentKeywordResponseDto insertSearchKeyword(String keyword) {
        return RecentKeywordResponseDto.from(keywordService.saveRecentKeyword(keyword));
    }

    public List<RecentKeywordResponseDto> insertSearchKeywords(Collection<String> keywords) {
        return keywordService.saveRecentKeywords(keywords).stream().map(RecentKeywordResponseDto::from).collect(Collectors.toList());
    }

    public List<RecentKeywordResponseDto> findTop10RecentKeyword() {
        return keywordService.getRecentTop10Keyword().stream().map(RecentKeywordResponseDto::from).collect(Collectors.toList());
    }

}
