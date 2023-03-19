package com.empty.searcher.common.domain.search.service.impl;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.service.BlogSearchService;
import org.springframework.stereotype.Service;

@Service
public class NaverBlogSearchService implements BlogSearchService {

    @Override
    public BlogContent searchContent(String query, String sort, Integer page, Integer size) {
        return null;
    }
}
