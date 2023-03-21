package com.empty.searcher.common.base.client.service;

import com.empty.searcher.common.base.client.NaverClient;
import com.empty.searcher.common.base.client.dto.NaverBlogContentResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NaverBlogApiService {

    private final NaverClient naverClient;

    public NaverBlogContentResponseDto findBlogContent(String query, String sort, int start, int display) {

        try {
            return naverClient.findBlogContent(query, sort, start, display);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
