package com.modern.training.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modern.training.platform.service.watchlist.WatchlistService;

import io.micrometer.core.annotation.Timed;

@RestController
public class ModernTrainingPlatformController {

	@Autowired
	WatchlistService watchlistService;

	@Timed
	@GetMapping("/company-profile/{ticker}")
	@ResponseBody
	public ResponseEntity<String> getCompanyProfile(@PathVariable String ticker) {
		return new ResponseEntity<String>(watchlistService.getSymbolProfile(ticker), HttpStatus.OK);
	}

}
