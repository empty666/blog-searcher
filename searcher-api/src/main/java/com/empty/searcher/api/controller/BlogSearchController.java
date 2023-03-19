package com.empty.searcher.api.controller;

import com.empty.searcher.api.dto.BlogSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog-search")
@RequiredArgsConstructor
public class BlogSearchController {

    public void findAllContentsByRequest(@RequestParam BlogSearchRequestDto requestDto) {

    }
}
