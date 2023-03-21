package com.empty.searcher.common.base.client.service;

import com.empty.searcher.common.base.client.KakaoClient;
import com.empty.searcher.common.base.client.dto.KakaoBlogContentResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoBlogApiService {

    private final KakaoClient kakaoClient;

    public KakaoBlogContentResponseDto findBlogContent(String query, String sort, int page, int size) {

        log.info("Called KakaoBlogApiService");

        try {
            return kakaoClient.findBlogContent(query, sort, page, size);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
