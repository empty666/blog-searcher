package com.empty.searcher.api.keyword.service;

import com.empty.searcher.api.keyword.dto.RecentKeywordResponseDto;
import com.empty.searcher.common.domain.keyword.service.RecentKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RecentKeywordApplication {
    private final RecentKeywordService keywordService;

    public List<RecentKeywordResponseDto> findTop10RecentKeyword() {
        return keywordService.getRecentTop10Keyword().stream().map(RecentKeywordResponseDto::from).collect(Collectors.toList());
    }

}
