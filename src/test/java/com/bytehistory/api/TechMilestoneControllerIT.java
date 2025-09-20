package com.bytehistory.api;

import com.bytehistory.api.dtos.TechMilestoneResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RestTestConfig
class TechMilestoneControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

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
}
