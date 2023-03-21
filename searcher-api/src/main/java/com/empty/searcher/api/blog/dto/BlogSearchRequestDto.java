package com.empty.searcher.api.blog.dto;

import com.empty.searcher.common.domain.search.dto.BlogSearchSort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogSearchRequestDto {

    private Integer page;
    private Integer size;

    private List<String> query;
    private BlogSearchSort sort;
}
