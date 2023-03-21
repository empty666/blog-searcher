package com.empty.searcher.common.domain.keyword.event;

import com.empty.searcher.common.base.event.AppEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecentKeywordHitEvent implements AppEvent {
    private List<String> keywords;
}
