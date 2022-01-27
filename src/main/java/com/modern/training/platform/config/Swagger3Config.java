package com.modern.training.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class Swagger3Config {                                    
    @Bean
    public OpenAPI customOpenAPI() { 
        return new OpenAPI()
        		 .info(new Info()
        				 .title("sample application API")
        				 .version("1")
        				           .description("Swagger api")
        				           .termsOfService("http://swagger.io/terms/")
        				           .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}