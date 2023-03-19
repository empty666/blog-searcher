package com.empty.searcher.common.domain.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BlogContent {

    private int totalCount;
    private int totalPage;
    private int offset;
    private int size;


    public int getTotalPage() {
        return this.totalCount / this.size + (this.totalCount % this.size == 0 ? 0  : 1);
    }

    private List<BlogDocument> documents;
}
