package com.empty.searcher.common.base.client.dto;

import com.empty.searcher.common.domain.search.dto.BlogContent;
import com.empty.searcher.common.domain.search.dto.BlogDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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

        @JsonProperty("blogname")
        private String blogName;
        private String thumbnail;

        @JsonProperty("datetime")
        private Date dateTime;

        public BlogDocument to() {
            return BlogDocument.builder()
                .title(this.getTitle())
                .description(this.getContents())
                .linkUrl(this.getUrl())
                .blogName(this.getBlogName())
                .updatedAt(this.getDateTime())
                .build();
        }
    }

    public BlogContent to(int offset, int size) {

        return BlogContent.builder()
            .totalCount(this.meta.getPageableCount())
            .offset(offset)
            .size(size)
            .documents(this.getDocuments().stream().map(Document::to).collect(Collectors.toList()))
            .build();
    }
}