package com.modern.training.platform.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.modern.training.platform.config.environment.EnvironmentProperties;
import com.modern.training.platform.model.CompanyProfile;
import com.modern.training.platform.service.companyprofile.CompanyProfileServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyProfileClientImpl implements CompanyProfileClient{

	@Autowired
	private EnvironmentProperties envProperties;
	
	@Override
	public CompanyProfile getCompanyProfile(String ticker) {
		RestTemplate restTemplate = new RestTemplate();
		String url = createBackendURL(ticker);
		log.info("Request: "+url);
		CompanyProfile response = restTemplate.getForObject(url, CompanyProfile.class);
		log.info("Response: "+response);
		return response;
	}

	private String createBackendURL(String ticker) {
		UriComponentsBuilder urBuilder = UriComponentsBuilder.fromHttpUrl(envProperties.getCOMPANY_PROFILE_URL()).queryParam("symbol", ticker).queryParam("token", envProperties.getAPI_KEY());
		return urBuilder.toUriString();
	}
	
	

}
