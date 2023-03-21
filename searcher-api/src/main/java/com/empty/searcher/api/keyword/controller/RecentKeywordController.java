package com.empty.searcher.api.keyword.controller;

import com.empty.searcher.api.keyword.service.RecentKeywordApplication;
import com.empty.searcher.api.keyword.dto.RecentKeywordResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recent-keyword")
@RequiredArgsConstructor
public class RecentKeywordController {

    private final RecentKeywordApplication application;

    @GetMapping("/v1/top-10")
    public @ResponseBody List<RecentKeywordResponseDto> findTop10RecentKeyword() {
        return application.findTop10RecentKeyword();
    }
}
