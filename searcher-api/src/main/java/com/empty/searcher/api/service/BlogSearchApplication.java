package com.empty.searcher.api.service;

import com.empty.searcher.api.dto.BlogSearchRequestDto;
import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogSearchParam;
import com.empty.searcher.common.domain.search.service.BlogSearchProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchApplication {

    private final BlogSearchProcessor searchProcessor;

    public BlogContent searchBlogContent(BlogSearchRequestDto request) {
        return searchProcessor.search(BlogSearchParam.builder()
            .page(request.getPage())
            .size(request.getSize())
            .sort(request.getSort())
            .queries(request.getQuery())
            .build()
        );
    }
}
