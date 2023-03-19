package com.empty.searcher.api.controller;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.service.impl.KakaoBlogSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final KakaoBlogSearchService kakaoBlogSearchService;
    @GetMapping("/v1/test")
    public void test() {

        BlogContent response = kakaoBlogSearchService.searchContent("Hello", "accuracy", 1, 10);
        log.info("REsponse : {}", response);
    }
}
