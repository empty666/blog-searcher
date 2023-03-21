package com.empty.searcher.api.blog.dto;

import com.empty.searcher.common.domain.search.dto.BlogSearchSort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogSearchRequestDto {

    @Range(min = 1, max = 50, message = "페이지는 1부터 최대 50까지 입력 가능합니다.")
    private Integer page;

    @Range(min = 1, max = 50, message = "컨텐츠 조회는 1부터 최대 50까지 입력 가능합니다.")
    private Integer size;

    @NotEmpty(message = "검색어는 필수 입력 값 입니다.")
    private List<String> query;

    @Builder.Default
    private BlogSearchSort sort = BlogSearchSort.ACCURACY;
}
