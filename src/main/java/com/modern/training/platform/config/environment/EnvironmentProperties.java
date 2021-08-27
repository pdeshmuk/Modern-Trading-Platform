package com.modern.training.platform.config.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class EnvironmentProperties {
	@Value("${api.key.sandbox}")
	private String API_KEY;
	@Value("${stock.profile.url}")
	private String COMPANY_PROFILE_URL;
}
