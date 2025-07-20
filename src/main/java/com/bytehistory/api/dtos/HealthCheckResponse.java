package com.bytehistory.api.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response object representing the health status of the service.")
public record HealthCheckResponse(

        @Schema(description = "Overall status of the application", example = "UP")
        String status,

        @Schema(description = "Brief message describing the health state", example = "Service is running")
        String message
) {
}
