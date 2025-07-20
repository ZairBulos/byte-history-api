package com.bytehistory.api;

import com.bytehistory.api.dtos.HealthCheckResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RestTestConfig
class HealthControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnHealthStatusSuccessfully() {
        var response = restTemplate.getForEntity("/api/health", HealthCheckResponse.class);
        var body = response.getBody();

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(body).isNotNull();
        assertThat(body.status()).isEqualTo("UP");
        assertThat(body.message()).isEqualTo("Service is running");
    }
}
