package com.empty.searcher.common.domain.search.service.impl;

import com.empty.searcher.common.base.client.NaverBlogApiService;
import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogSearchSort;
import com.empty.searcher.common.domain.search.service.BlogSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NaverBlogSearchService implements BlogSearchService {

    private final NaverBlogApiService naverBlogApiService;
    @Override
    public BlogContent searchContent(String query, BlogSearchSort sort, Integer page, Integer size) {
        return naverBlogApiService.findBlogContent(query, this.getSortKey(sort), this.calcStartIndex(page, size), size).to();
    }

    @Override
    public String getSortKey(BlogSearchSort sort) {

        switch (sort) {
            case ACCURACY:
                return "sim";

            case RECENCY:
            default:
                return "date";
        }
    }

    private int calcStartIndex(int page, int size) {
        return page == 1 ? page : ((page - 1) * size) + 1;
    }
}
