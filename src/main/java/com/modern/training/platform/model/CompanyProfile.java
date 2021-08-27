package com.modern.training.platform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyProfile {
	private String country;
	private String currency;
	private String exchange;
	private String ipo;
	private long marketCapitalization;
	private String name; 
	private String phone;
	private double shareOutstanding; 
	private String ticker; 
	private String weburl; 
	private String logo; 
	private String finnhubIndustry; 

}
