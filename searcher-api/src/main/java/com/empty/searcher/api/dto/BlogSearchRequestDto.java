package com.empty.searcher.api.dto;

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
    private String sort;
}
