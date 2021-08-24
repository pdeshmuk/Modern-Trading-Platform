package com.modern.training.platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modern.training.platform.model.SymbolProfile;
import com.modern.training.platform.service.watchlist.WatchlistService;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ModernTrainingPlatformController {

	private final WatchlistService watchlistService;

	@GetMapping("/company-profile/{ticker}")
	@ResponseBody
	@Timed
	public ResponseEntity<SymbolProfile> getCompanyProfile(
			@PathVariable String ticker,
			@RequestParam(defaultValue = "30") int days) {
		return new ResponseEntity<>(watchlistService.getSymbolProfile(ticker, days), HttpStatus.OK);
	}

}
