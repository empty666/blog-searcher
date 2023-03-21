package com.empty.searcher.common.domain.keyword.event.listener

import com.empty.searcher.common.base.redis.RedisLockRepository
import com.empty.searcher.common.domain.keyword.event.RecentKeywordHitEvent
import com.empty.searcher.common.domain.keyword.service.RecentKeywordService
import spock.lang.Specification

class RecentKeywordEventListenerTest extends Specification {

    def redisLocRepository = Mock(RedisLockRepository)
    def keywordService = Mock(RecentKeywordService)

    def listener =  new  RecentKeywordEventListener(redisLocRepository, keywordService)

    def "최근 조회 키워드 처리 테스트"()  {
        given:
        def event = new RecentKeywordHitEvent(["hello", "world"])
        redisLocRepository.lock(_) >>> [false, false, false, true]

        when:
        listener.on(event)

        then:
        event.getKeywords().size() * keywordService.increaseHitCountByKeyword(_)
        event.getKeywords().size() * redisLocRepository.unlock(_)
    }

}
