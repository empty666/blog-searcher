package com.empty.searcher.common.base.client;

import com.empty.searcher.common.base.client.dto.KakaoBlogContentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoBlogApiService {

    private final KakaoClient kakaoClient;

    public KakaoBlogContentResponseDto findBlogContent(String query, String sort, int page, int size) {
        try {
            return kakaoClient.findBlogContent(query, sort, page, size);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
