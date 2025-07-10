package com.bytehistory.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledCacheEvictor {

    private final CacheManager cacheManager;

    @Scheduled(cron = "0 5 0 * * *", zone = "America/Argentina/Buenos_Aires")
    public void clearTechMilestoneCache() {
        Cache cache = cacheManager.getCache("techMilestone");
        if (cache != null) {
            cache.clear();
            System.out.println("Tech milestone cache cleared");
        }
    }
}
