package com.modern.training.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modern.training.platform.model.CompanyProfile;
import com.modern.training.platform.service.companyprofile.CompanyProfileService;

import io.micrometer.core.annotation.Timed;

@RestController
public class CompanyProfileController {
	
	@Autowired
	private CompanyProfileService companyProfileService;

	@GetMapping("/company-details/{ticker}")
	@ResponseBody
	@Timed
	public ResponseEntity<?> getCompanyDetails(
			@PathVariable String ticker) {
		CompanyProfile response = companyProfileService.getCompanyProfile(ticker);
		if(response != null)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity("Error in getting Data", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
