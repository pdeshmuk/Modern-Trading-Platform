package com.perficient.modern.training.platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModerntrainingPlatformController {

	@GetMapping("/hello")
	@ResponseBody 
	public ResponseEntity<String> getWelcomeMessage() {
		return new ResponseEntity<String>("Test", HttpStatus.OK);
	}

}
