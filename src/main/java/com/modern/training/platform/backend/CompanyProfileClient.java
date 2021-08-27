package com.modern.training.platform.backend;

import com.modern.training.platform.model.CompanyProfile;

public interface CompanyProfileClient {
	public CompanyProfile getCompanyProfile(String ticker); 
}
