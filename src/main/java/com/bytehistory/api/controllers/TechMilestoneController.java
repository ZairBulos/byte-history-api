package com.bytehistory.api.controllers;

import com.bytehistory.services.TechMilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tech-milestones")
@RequiredArgsConstructor
public class TechMilestoneController {
    private final TechMilestoneService service;

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }
}
