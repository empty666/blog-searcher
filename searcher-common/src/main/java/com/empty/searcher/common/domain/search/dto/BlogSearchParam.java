package com.empty.searcher.common.domain.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BlogSearchParam {

    private int page;
    private int size;

    private List<String> queries;
    private BlogSearchSort sort;
}
