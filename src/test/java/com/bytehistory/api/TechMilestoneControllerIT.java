package com.bytehistory.api;

import com.bytehistory.api.dtos.TechMilestoneResponse;
import com.bytehistory.api.filters.RateLimitFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RestTestConfig
class TechMilestoneControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RateLimitFilter rateLimitFilter;

    @BeforeEach
    void beforeEach() {
        rateLimitFilter.clearCache();
    }

    @Test
    void shouldReturnTodayMilestone() {
        var response = restTemplate.getForEntity("/api/tech-milestones", TechMilestoneResponse.class);
        var body = response.getBody();

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(body).isNotNull();
        assertThat(body.milestone()).isEqualTo("Test Milestone");
        assertThat(body.model()).isEqualTo("test-model");
        assertThat(body.date()).isNotBlank();
    }

    @Test
    void shouldReturn429AfterExceedingRateLimit() {
        for (int i = 0; i < 10; i++) {
            restTemplate.getForEntity("/api/tech-milestones", TechMilestoneResponse.class);
        }

        var response = restTemplate.getForEntity("/api/tech-milestones", TechMilestoneResponse.class);
        assertThat(response.getStatusCode().value()).isEqualTo(429);
    }
}
