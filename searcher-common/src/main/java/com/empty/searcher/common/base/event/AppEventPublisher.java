package com.empty.searcher.common.base.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void send(AppEvent e)  {
        applicationEventPublisher.publishEvent(e);
    }

}
