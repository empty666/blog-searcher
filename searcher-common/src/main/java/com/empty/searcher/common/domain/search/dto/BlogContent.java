package com.empty.searcher.common.domain.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BlogContent {

    private BlogPagination pagination;
    private List<BlogDocument> documents;

    @Data
    @Builder
    public static class BlogPagination {
        private int totalCount;
        private int totalPage;
        private int offset;
        private int size;

        public int getTotalPage() {
            return this.totalCount / this.size + (this.totalCount % this.size == 0 ? 0  : 1);
        }
    }

}
