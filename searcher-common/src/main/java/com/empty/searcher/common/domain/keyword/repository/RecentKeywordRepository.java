package com.empty.searcher.common.domain.keyword.repository;

import com.empty.searcher.common.domain.keyword.entity.RecentKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RecentKeywordRepository extends JpaRepository<RecentKeyword, String>, RecentKeywordRepositoryCustom {

    List<RecentKeyword> findTop10ByOrderByHitCountDesc();
}
