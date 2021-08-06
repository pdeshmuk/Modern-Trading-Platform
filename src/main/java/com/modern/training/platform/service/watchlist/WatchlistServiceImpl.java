package com.modern.training.platform.service.watchlist;

import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImpl implements WatchlistService{

	@Override
	public String getSymbolProfile(String symbol) {
		return symbol;
	}

}
