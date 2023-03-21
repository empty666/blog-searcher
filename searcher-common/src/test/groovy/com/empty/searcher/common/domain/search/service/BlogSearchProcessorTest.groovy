package com.empty.searcher.common.domain.search.service

import com.empty.searcher.common.domain.search.dto.BlogContent
import com.empty.searcher.common.domain.search.dto.BlogDocument
import com.empty.searcher.common.domain.search.dto.BlogSearchParam
import com.empty.searcher.common.domain.search.dto.BlogSearchSort
import com.empty.searcher.common.domain.search.service.impl.KakaoBlogSearchService
import com.empty.searcher.common.domain.search.service.impl.NaverBlogSearchService
import spock.lang.Specification

class BlogSearchProcessorTest extends Specification{

    def kakaoSearchService = Mock(KakaoBlogSearchService)
    def naverSearchService = Mock(NaverBlogSearchService)

    def processor = new BlogSearchProcessor(kakaoSearchService, naverSearchService)

    def defaultSize = 10

    def "블로그 검색 테스트"() {
        /*
            블로그 검색 Service 실행 시, 오류 여부에 따라 다른 서비스 검색 여부를 검증
         */

        given:
        def searchParam = generateSearchParam(1, 3, List.of("Hello", "World"), BlogSearchSort.ACCURACY)
        processor.init()

        def blogContent = generateBlogContent(1, defaultSize, [generateDocument("TEST-01", "TESTING", "TEST_BLOG")])

        when:
        processor.search(searchParam)

        then:
        calledByKakaoServiceCount * kakaoSearchService.searchContent(_,_,_,_) >> {
            if (isKakaoException) {
                throw new Exception()
            } else {
                return blogContent
            }
        }

        calledByNaverServiceCount * naverSearchService.searchContent(_,_,_,_) >> {
            if (isNaverException) {
                throw new Exception()
            } else {
                return blogContent
            }
        }

        where:
        isKakaoException    |isNaverException   |calledByKakaoServiceCount  |calledByNaverServiceCount
        false               |false              |1                          |0
        true                |false              |1                          |1
        true                |true               |1                          |1
    }


    //region Generate VO
    BlogSearchParam generateSearchParam(int page, int size, List<String> queries, BlogSearchSort sort) {
        return BlogSearchParam.builder()
        .page(page)
        .size(size)
        .queries(queries)
        .sort(sort)
        .build();
    }

    BlogContent generateBlogContent(int totalCount, int size, List<BlogDocument> documents) {
        return BlogContent.builder()
        .pagination(BlogContent.BlogPagination.builder().totalCount(totalCount).size(size).build())
        .documents(documents)
        .build()
    }

    BlogDocument generateDocument(String title, String description, String blogName) {
        return BlogDocument.builder()
        .title(title)
        .description(description)
        .blogName(blogName)
        .build()
    }
    //endregion
}
