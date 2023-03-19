package com.empty.searcher.common.domain.search.service;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogSearchParam;
import com.empty.searcher.common.domain.search.service.impl.KakaoBlogSearchService;
import com.empty.searcher.common.domain.search.service.impl.NaverBlogSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class BlogSearchProcessor {

    private List<BlogSearchService> searchServices = Collections.emptyList();

    private final KakaoBlogSearchService kakaoBlogSearchService;
    private final NaverBlogSearchService naverBlogSearchService;

    @PostConstruct
    void init() {
        searchServices = new ArrayList<BlogSearchService>();

        searchServices.add(kakaoBlogSearchService);
        searchServices.add(naverBlogSearchService);
    }

    public BlogContent search(BlogSearchParam param) {

        for (BlogSearchService service : searchServices) {
            try {
                return service.searchContent(this.parseQueryString(param.getQueries()), param.getSort(), param.getPage(), param.getSize());
            } catch (Exception ex) {
                log.error("Blog Search Error : {}", service.getClass().getName());
            }
        }

        return null;
    }

    private String parseQueryString(List<String> queries) {
        return String.join(" ", queries);
    }
}
