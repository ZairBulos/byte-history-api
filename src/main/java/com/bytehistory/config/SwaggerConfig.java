package com.bytehistory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Byte History API")
                        .description("REST API that serves daily AI-generated tech milestones in Spanish.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Zair Bulos")
                                .email("buloszair@gmail.com")
                                .url("https://github.com/ZairBulos")
                        )
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")
                        )
                );
    }
}
