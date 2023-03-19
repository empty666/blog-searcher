package com.empty.searcher.api.controller;

import com.empty.searcher.common.base.client.NaverClient;
import com.empty.searcher.common.base.client.dto.NaverBlogContentResponseDto;
import com.empty.searcher.common.domain.search.service.impl.KakaoBlogSearchService;
import com.empty.searcher.common.domain.search.service.impl.NaverBlogSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final KakaoBlogSearchService kakaoBlogSearchService;
    private final NaverBlogSearchService naverBlogSearchService;
    private final NaverClient naverClient;

    @GetMapping("/v1/test")
    public @ResponseBody NaverBlogContentResponseDto test() {

        NaverBlogContentResponseDto response = naverClient.findBlogContent("Hello", "sim", 1, 10);
        log.info("Response : {}", response);

        return response;
    }
}
