package com.empty.searcher.common.domain.search.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BlogContent {

    private int totalCount;
    private int totalPage;
    private int offset;
    private int size;

    private List<BlogDocument> documents;
}
