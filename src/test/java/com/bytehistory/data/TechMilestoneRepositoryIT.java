package com.bytehistory.data;

import com.bytehistory.TestConfig;
import com.bytehistory.data.entities.TechMilestone;
import com.bytehistory.data.repositories.TechMilestoneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@TestConfig
class TechMilestoneRepositoryIT {

    @Autowired
    private TechMilestoneRepository repository;

    @Test
    void shouldFindTodayMilestone() {
        Optional<TechMilestone> result = repository.findTodayMilestone();

        assertThat(result).isPresent();
        assertThat(result.get().getMilestone()).isEqualTo("Test Milestone");
        assertThat(result.get().getAiModel()).isEqualTo("test-model");
    }
}
