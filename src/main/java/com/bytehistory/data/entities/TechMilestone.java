package com.bytehistory.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "tech_milestones")
@NoArgsConstructor @AllArgsConstructor @Getter
public class TechMilestone {

    @Id
    private Long id;

    @Column(name = "milestone", nullable = false, columnDefinition = "TEXT")
    private String milestone;

    @Column(name = "ai_model", nullable = false, length = 50)
    private String aiModel;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
