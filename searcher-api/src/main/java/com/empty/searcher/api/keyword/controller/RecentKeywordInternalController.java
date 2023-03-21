package com.empty.searcher.api.keyword.controller;

import com.empty.searcher.api.keyword.service.RecentKeywordApplication;
import com.empty.searcher.api.keyword.dto.RecentKeywordResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/internal-api/recent-keyword")
@RequiredArgsConstructor
public class RecentKeywordInternalController {

    private final RecentKeywordApplication application;

    @PostMapping("/v1/create")
    public @ResponseBody List<RecentKeywordResponseDto> insertRecentKeyword(@RequestBody Collection<String> keywords) {
        return application.insertSearchKeywords(keywords);
    }
}
