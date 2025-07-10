package com.bytehistory.api.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

@Schema(description = "Structure returned when an error occurs during an API request.")
public record ErrorResponse(
        @Schema(description = "Timestamp when the error occurred", example = "2025-07-04T00:05:00Z")
        OffsetDateTime timestamp,

        @Schema(description = "HTTP status code", example = "404")
        int status,

        @Schema(description = "HTTP status reason phrase", example = "NOT_FOUND")
        String error,

        @Schema(description = "Detailed error message", example = "Tech milestone for today not found")
        String message,

        @Schema(description = "Request path that caused the error", example = "/api/tech-milestones")
        String path
) {
}
