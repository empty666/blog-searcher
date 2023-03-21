package com.empty.searcher.common.domain.keyword.service;

import com.empty.searcher.common.domain.keyword.entity.RecentKeyword;
import com.empty.searcher.common.domain.keyword.repository.RecentKeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecentKeywordService {

    private final RecentKeywordRepository repository;

    public List<RecentKeyword> getRecentTop10Keyword() {
        return repository.findTop10ByOrderByHitCountDesc();
    }

    @Transactional
    public void increaseHitCountByKeyword(String keyword) {

        long resultCnt = repository.updateHitCountIncreaseByKeywordIn(List.of(keyword));
        if (resultCnt == 0) {
            this.saveRecentKeyword(keyword);
        }
    }

    @Transactional
    public void saveRecentKeyword(String keyword) {
        repository.save(RecentKeyword.createRecentKeyword(keyword));
    }

    @Transactional
    public List<RecentKeyword> saveRecentKeywords(Collection<String> keywords) {
        List<RecentKeyword> datas = keywords.stream().map(RecentKeyword::createRecentKeyword).collect(Collectors.toList());
        return repository.saveAll(datas);
    }
}
