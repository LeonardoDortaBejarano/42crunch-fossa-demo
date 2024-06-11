package com.example.demo.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
/* 
	@Bean
	public OpenAPI customOpenAPI() {
		
		return new OpenAPI()
				.info(new Info().title("Demo Authentication Service"))	
                .specVersion(SpecVersion.V30)
				.addSecurityItem(new SecurityRequirement().addList("DemoSecurityScheme"))
				.components(new Components().addSecuritySchemes("DemoSecurityScheme", new SecurityScheme()
						.name("DemoSecurityScheme").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
		
	} */

}
