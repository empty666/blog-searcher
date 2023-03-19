package com.empty.searcher.common.base.client.dto;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoBlogContentResponseDto {

    private Meta meta;
    private List<Document> documents;

    @Data
    private static class Meta {

        @JsonProperty("total_count")
        private Integer totalCount;

        @JsonProperty("pageable_count")
        private Integer pageableCount;

        @JsonProperty("is_end")
        private boolean isEnd;
    }

    @Data
    private static class Document {

        private String title;
        private String contents;
        private String url;
        private String blogName;
        private String thumbnail;
        private LocalDateTime dateTime;
    }

    public BlogContent to() {

        List<BlogDocument> docList = this.documents.stream().map(item -> {
            return BlogDocument.builder()
                .title(item.getTitle())
                .description(item.getContents())
                .linkUrl(item.getUrl())
                .blogName(item.getBlogName())
                .updatedAt(item.getDateTime())
                .build();
        }).collect(Collectors.toList());

        return BlogContent.builder()
            .totalCount(this.meta.getTotalCount())
            .documents(docList)
            .build();
    }
}