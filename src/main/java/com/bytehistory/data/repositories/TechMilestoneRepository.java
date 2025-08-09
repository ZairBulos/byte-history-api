package com.bytehistory.data.repositories;

import com.bytehistory.data.entities.TechMilestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechMilestoneRepository extends JpaRepository<TechMilestone, Long> {

    @Query(
            value = "SELECT * FROM tech_milestones WHERE CAST(created_at AS DATE) = CURRENT_DATE ORDER BY created_at DESC LIMIT 1",
            nativeQuery = true
    )
    Optional<TechMilestone> findTodayMilestone();
}
