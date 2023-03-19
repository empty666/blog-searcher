package com.empty.searcher.common.base.client.dto;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogDocument;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class NaverBlogContentResponseDto {

    private int total;
    private int display;
    private int start;

    private List<Item> items;

    @Data
    private static class Item {

        private String title;
        private String link;
        private String description;

        @JsonProperty("bloggername")
        private String bloggerName;

        @JsonProperty("bloggerlink")
        private String bloggerLink;

        @JsonProperty("postdate")
        @JsonFormat(pattern = "yyyyMMdd")
        private Date postDate;

        public BlogDocument to() {
            return BlogDocument.builder()
                .title(this.getTitle())
                .description(this.getDescription())
                .linkUrl(this.getLink())
                .blogName(this.getBloggerName())
                .updatedAt(this.getPostDate())
                .build();
        }
    }

    public BlogContent to() {
        return BlogContent.builder()
            .totalCount(total)
            .offset(start)
            .size(display)
            .documents(this.getItems().stream().map(Item::to).collect(Collectors.toList()))
            .build();
    }
}
