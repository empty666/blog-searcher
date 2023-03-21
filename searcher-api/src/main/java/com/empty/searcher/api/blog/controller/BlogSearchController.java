package com.empty.searcher.api.blog.controller;

import com.empty.searcher.api.blog.dto.BlogSearchRequestDto;
import com.empty.searcher.api.blog.service.BlogSearchApplication;
import com.empty.searcher.common.domain.search.dto.BlogContent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog-search")
@RequiredArgsConstructor
public class BlogSearchController {

    private final BlogSearchApplication application;

    @GetMapping("/v1/search")
    public BlogContent findAllContentsByRequest(BlogSearchRequestDto requestDto) {
        return application.searchBlogContent(requestDto);
    }
}
