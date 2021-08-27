package com.modern.training.platform.service.companyprofile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modern.training.platform.backend.CompanyProfileClientImpl;
import com.modern.training.platform.model.CompanyProfile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyProfileServiceImpl implements CompanyProfileService{
	
	@Autowired
	private CompanyProfileClientImpl companyProfileClientImpl;
	
	private static String NO_SCRIPT_ALLOWED = "^[A-Za-z0-9]+";
	
	@Override
	public CompanyProfile getCompanyProfile(String ticker) {
		if(validateInputTicker(ticker)) {
			return companyProfileClientImpl.getCompanyProfile(ticker);
		}
		else {
			log.error("Invalid Ticker");
		}
		return null;
	}
	
	private boolean validateInputTicker(String ticker) {
		Pattern p = Pattern.compile(NO_SCRIPT_ALLOWED);
		Matcher m = p.matcher(ticker);
		boolean validInput = m.matches();
		return validInput;
	}

}

