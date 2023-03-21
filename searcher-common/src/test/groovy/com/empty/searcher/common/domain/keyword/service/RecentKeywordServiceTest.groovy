package com.empty.searcher.common.domain.keyword.service

import com.empty.searcher.common.domain.keyword.repository.RecentKeywordRepository
import spock.lang.Specification

class RecentKeywordServiceTest extends Specification {

    def repository = Mock(RecentKeywordRepository)

    def service = new RecentKeywordService(repository)

    def "최근 조회 기록 여부에 따른 Recent Keyword 생성 여부 테스트"() {
        given:
        def keyword = "TEST"

        repository.updateHitCountIncreaseByKeywordIn([keyword]) >> resultCnt

        when:
        service.increaseHitCountByKeyword(keyword)

        then:
        calledBySaveCount * repository.save(_)

        where:
        resultCnt   |  calledBySaveCount
        0           |   1
        1           |   0
    }
}
