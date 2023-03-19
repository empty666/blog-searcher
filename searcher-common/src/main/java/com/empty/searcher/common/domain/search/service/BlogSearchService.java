package com.empty.searcher.common.domain.search.service;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogDocument;

@FunctionalInterface
public interface BlogSearchService {

    BlogContent searchContent(String query, String sort, Integer page, Integer size);
}
