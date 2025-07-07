package com.bytehistory.data;

import com.bytehistory.data.entities.TechMilestone;
import com.bytehistory.data.repositories.TechMilestoneRepository;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class DatabaseSeederService {

    private final TechMilestoneRepository repository;

    @Autowired
    public DatabaseSeederService(TechMilestoneRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).info("----- Seeding database -----");

        repository.deleteAll();
        repository.save(new TechMilestone(1L, "Test Milestone", "test-model", OffsetDateTime.now()));
    }
}
