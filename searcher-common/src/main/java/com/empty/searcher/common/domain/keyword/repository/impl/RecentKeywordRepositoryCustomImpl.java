package com.empty.searcher.common.domain.keyword.repository.impl;

import com.empty.searcher.common.config.data.BlogSearcherQueryDslRepositorySupport;
import com.empty.searcher.common.domain.keyword.entity.QRecentKeyword;
import com.empty.searcher.common.domain.keyword.entity.RecentKeyword;
import com.empty.searcher.common.domain.keyword.repository.RecentKeywordRepositoryCustom;

import java.time.LocalDateTime;
import java.util.Collection;

public class RecentKeywordRepositoryCustomImpl extends BlogSearcherQueryDslRepositorySupport implements RecentKeywordRepositoryCustom {

    private static final QRecentKeyword recentKeyword = new QRecentKeyword("recentKeyword");

    public RecentKeywordRepositoryCustomImpl() {
        super(RecentKeyword.class);
    }

    @Override
    public long updateHitCountIncreaseByKeywordIn(Collection<String> keywords) {
        return update(recentKeyword)
            .set(recentKeyword.hitCount, recentKeyword.hitCount.add(1))
            .set(recentKeyword.updatedAt, LocalDateTime.now())
            .where(recentKeyword.keyword.in(keywords))
            .execute();
    }
}
