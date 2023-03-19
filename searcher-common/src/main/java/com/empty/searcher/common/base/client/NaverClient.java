package com.empty.searcher.common.base.client;

import com.empty.searcher.common.base.client.config.NaverClientHeadersConfig;
import com.empty.searcher.common.base.client.dto.NaverBlogContentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naver-open-api", url = "${blog-searcher.client.host.naver}",  configuration = NaverClientHeadersConfig.class)
public interface NaverClient {

    @GetMapping("/v1/search/blog.json")
    NaverBlogContentResponseDto findBlogContent(@RequestParam(name = "query") String query, @RequestParam(name="sort") String sort, @RequestParam(name="start") int start, @RequestParam(name="display") int display);
}
