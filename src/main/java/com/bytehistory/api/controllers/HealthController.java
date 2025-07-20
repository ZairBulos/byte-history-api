package com.bytehistory.api.controllers;

import com.bytehistory.api.dtos.ErrorResponse;
import com.bytehistory.api.dtos.HealthCheckResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Health Check")
public class HealthController {

    @Operation(
            summary = "Get basic health status of the application",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Service is running",
                            content = @Content(schema = @Schema(implementation = HealthCheckResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "429",
                            description = "Rate limit exceeded",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
            }
    )
    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(new HealthCheckResponse("UP", "Service is running"));
    }
}
