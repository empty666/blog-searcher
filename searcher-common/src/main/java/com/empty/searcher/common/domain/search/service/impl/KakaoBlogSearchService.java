package com.empty.searcher.common.domain.search.service.impl;

import com.empty.searcher.common.base.client.KakaoBlogApiService;
import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoBlogSearchService implements BlogSearchService {

    private final KakaoBlogApiService kakaoBlogApiService;

    @Override
    public BlogContent searchContent(String query, String sort, Integer page, Integer size) {
        return kakaoBlogApiService.findBlogContent(query, sort, page, size).to();
    }
}
