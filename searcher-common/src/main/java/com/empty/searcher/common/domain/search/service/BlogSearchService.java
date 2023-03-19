package com.empty.searcher.common.domain.search.service;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogSearchSort;

public interface BlogSearchService {

    BlogContent searchContent(String query, BlogSearchSort sort, Integer page, Integer size);
    String getSortKey(BlogSearchSort sort);
}
