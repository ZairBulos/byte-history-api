package com.bytehistory.api.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response object representing a daily tech milestone generated by AI.")
public record TechMilestoneResponse(

        @Schema(description = "The content of the tech milestone", example = "El 4 de julio de 1996, Hotmail, uno de los primeros servicios de correo electrónico web, se lanzó al público.")
        String milestone,

        @Schema(description = "The AI model used to generate the milestone", example = "gemini-2.0-flash")
        String model,

        @Schema(description = "Formatted current date in Spanish", example = "Viernes, 4 de Julio de 2025")
        String date
) {
}
