package com.empty.searcher.api.blog.service;

import com.empty.searcher.api.blog.dto.BlogSearchRequestDto;
import com.empty.searcher.common.base.event.AppEventPublisher;
import com.empty.searcher.common.domain.keyword.event.RecentKeywordHitEvent;
import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogSearchParam;
import com.empty.searcher.common.domain.search.service.BlogSearchProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogSearchApplication {

    private final BlogSearchProcessor searchProcessor;
    private final AppEventPublisher eventPublisher;

    public BlogContent searchBlogContent(BlogSearchRequestDto request) {


        BlogContent content = searchProcessor.search(BlogSearchParam.builder()
            .page(request.getPage())
            .size(request.getSize())
            .sort(request.getSort())
            .queries(request.getQuery())
            .build()
        );

        eventPublisher.send(new RecentKeywordHitEvent(request.getQuery()));

        return content;
    }
}
