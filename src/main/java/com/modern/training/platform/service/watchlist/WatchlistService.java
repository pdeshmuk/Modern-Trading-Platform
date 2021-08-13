package com.modern.training.platform.service.watchlist;

import com.modern.training.platform.model.SymbolProfile;

public interface WatchlistService {

	public SymbolProfile getSymbolProfile(String symbol, int days);
	
} 