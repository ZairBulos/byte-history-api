package com.bytehistory.services;

import com.bytehistory.TestConfig;
import com.bytehistory.api.dtos.TechMilestoneResponse;
import com.bytehistory.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestConfig
class TechMilestoneServiceIT {

    @Autowired
    private TechMilestoneService service;

    @Test
    void shouldReturnTodayMilestone() {
        TechMilestoneResponse result = service.get();

        assertThat(result).isNotNull();
        assertThat(result.milestone()).isEqualTo("Test Milestone");
        assertThat(result.model()).isEqualTo("test-model");
        assertThat(result.date()).isEqualTo(DateUtils.getCurrentDate());
    }
}
