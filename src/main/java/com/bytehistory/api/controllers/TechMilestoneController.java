package com.bytehistory.api.controllers;

import com.bytehistory.api.dtos.ErrorResponse;
import com.bytehistory.api.dtos.TechMilestoneResponse;
import com.bytehistory.services.TechMilestoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tech-milestones")
@RequiredArgsConstructor
@Tag(name = "Tech Milestones")
public class TechMilestoneController {
    private final TechMilestoneService service;

    @Operation(
            summary = "Get today's tech milestone",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Tech milestone successfully retrieved",
                            content = @Content(schema = @Schema(implementation = TechMilestoneResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No milestone found for today",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "429",
                            description = "Rate limit exceeded",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
            }
    )
    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(service.get());
    }
}
