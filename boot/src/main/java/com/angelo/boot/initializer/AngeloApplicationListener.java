package com.angelo.boot.initializer;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

/**
 * supportsEventType(..) && supportsSourceType(..)
 * 都返回true时，表示对所有事件均有兴趣
 */
public class AngeloApplicationListener implements GenericApplicationListener {
    @Override
    public boolean supportsEventType(ResolvableType resolvableType) {
        return true;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("-------------------- 对所有事件均有兴趣 --------------------");

        if (applicationEvent instanceof ApplicationStartedEvent) {
            System.out.println("-------------------- 仅对 ApplicationStartedEvent 有兴趣 --------------------");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
