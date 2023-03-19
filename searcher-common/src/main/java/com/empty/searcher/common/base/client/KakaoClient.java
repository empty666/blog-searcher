package com.empty.searcher.common.base.client;

import com.empty.searcher.common.base.client.config.KakaoClientHeadersConfig;
import com.empty.searcher.common.base.client.dto.KakaoBlogContentResponseDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(name = "kakao-open-api", url = "https://dapi.kakao.com",  configuration = KakaoClientHeadersConfig.class)
public interface KakaoClient {

    @GetMapping("/v2/search/blog")
    KakaoBlogContentResponseDto findBlogContent(@RequestParam(name = "query") String query, @RequestParam(name="sort") String sort, @RequestParam(name="page") int page, @RequestParam(name="size") int size);
}
