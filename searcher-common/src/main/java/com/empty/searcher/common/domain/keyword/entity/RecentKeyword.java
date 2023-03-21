package com.empty.searcher.common.domain.keyword.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recent_keyword")
@Entity
public class RecentKeyword {

    @Id
    @Column(name = "keyword", nullable = false)
    private String keyword;

    @Column(name = "hit_count", nullable = false)
    private long hitCount;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public static RecentKeyword createRecentKeyword(String keyword) {
        return RecentKeyword.builder().keyword(keyword).hitCount(1L).updatedAt(LocalDateTime.now()).build();
    }
}
