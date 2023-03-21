package com.empty.searcher.common.domain.keyword.repository;

import java.util.Collection;

public interface RecentKeywordRepositoryCustom {

    long updateHitCountIncreaseByKeywordIn(Collection<String> keywords);
}
