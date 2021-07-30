package com.perficient.modern.training.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.perficient.modern.training.platform.controller")
public class ModernTrainingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModernTrainingPlatformApplication.class, args);
	}

}
