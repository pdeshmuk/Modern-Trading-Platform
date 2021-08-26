package com.modern.training.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class Swagger3 {

	@Bean
    public OpenAPI customOpenAPI(@Value("${application-title}") String appTitle, @Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
     return new OpenAPI()
    	  .components(new Components().addSecuritySchemes("basic", getSecurityScheme()))
    	  .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
          .info(new Info()
          .title(appTitle)
          .version(appVersion)
          .description(appDesciption)
          .termsOfService("http://swagger.io/terms/")
          .license(new License().name("v1").url("http://springdoc.org")));
    }
	

	
	private SecurityScheme getSecurityScheme() {
		SecurityScheme scheme = new SecurityScheme();
		scheme.setScheme("basic");
		scheme.setName("basicAuth");
		scheme.setType(SecurityScheme.Type.HTTP);
		scheme.setIn(SecurityScheme.In.HEADER);
		return scheme;
	}
	
}
