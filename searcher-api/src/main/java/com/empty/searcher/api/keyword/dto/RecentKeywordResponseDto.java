package com.empty.searcher.api.keyword.dto;

import com.empty.searcher.common.domain.keyword.entity.RecentKeyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecentKeywordResponseDto {

    private String keyword;
    private Long hitCount;

    public static RecentKeywordResponseDto from(RecentKeyword keyword) {
        return RecentKeywordResponseDto.builder()
            .keyword(keyword.getKeyword())
            .hitCount(keyword.getHitCount())
            .build();
    }
}
