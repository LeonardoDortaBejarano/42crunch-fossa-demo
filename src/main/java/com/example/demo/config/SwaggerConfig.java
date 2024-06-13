package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI customOpenAPI() {
        Server localServerHttps = new Server();
        localServerHttps.setUrl("https://localhost:8080");
        localServerHttps.setDescription("Local development server (uses HTTPs)");

        /* Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Local development server (uses HTTPs)"); */

        
        return new OpenAPI()
                .info(new Info().title("Demo Authentication Service")
				.version("v1"))
                .servers(List.of(localServerHttps))
                .components(new Components()
                        .addSecuritySchemes("DemoSecurityScheme", new SecurityScheme()
                                .name("DemoSecurityScheme")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
			
    }
}
