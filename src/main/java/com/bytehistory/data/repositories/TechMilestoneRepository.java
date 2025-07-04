package com.bytehistory.data.repositories;

import com.bytehistory.data.entities.TechMilestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechMilestoneRepository extends JpaRepository<TechMilestone, Long> {

    @Query(value = "SELECT * FROM tech_milestones WHERE DATE(created_at) = CURRENT_DATE", nativeQuery = true)
    Optional<TechMilestone> findTodayMilestone();
}
