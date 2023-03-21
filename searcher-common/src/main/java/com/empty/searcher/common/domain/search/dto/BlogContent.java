package com.empty.searcher.common.domain.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class BlogContent {

    private BlogPagination pagination;
    private List<BlogDocument> documents;

    public static BlogContent emptyContent(int size) {
        return BlogContent.builder()
            .pagination(BlogPagination.builder().size(size).build())
            .documents(Collections.emptyList())
            .build();
    }
    @Data
    @Builder
    public static class BlogPagination {

        @Builder.Default
        private int totalCount = 0;

        @Builder.Default
        private int totalPage = 1;

        @Builder.Default
        private int offset = 1;
        @Builder.Default
        private int size = 10;

        public int getTotalPage() {
            return this.totalCount / this.size + (this.totalCount % this.size == 0 ? 0  : 1);
        }
    }

}
