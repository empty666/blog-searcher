package com.empty.searcher.common.domain.search.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BlogDocument {

    private String title;
    private String description;
    private String linkUrl;
    private String blogName;
    private LocalDateTime updatedAt;

}
