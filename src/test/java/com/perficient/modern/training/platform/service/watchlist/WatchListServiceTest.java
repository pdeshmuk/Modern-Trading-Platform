package com.perficient.modern.training.platform.service.watchlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.modern.training.platform.model.SymbolProfile;
import com.modern.training.platform.service.watchlist.WatchlistService;
import com.modern.training.platform.service.watchlist.WatchlistServiceImpl;

public class WatchListServiceTest {

	@Test
	public void testGetSymbolProfile() {
		
		WatchlistService service = new WatchlistServiceImpl();
		
		SymbolProfile profile = service.getSymbolProfile("TSLA", 30);

		assertNotNull(profile);
		assertEquals("TSLA", profile.getSymbol());
		assertEquals(30, profile.getQuoteList().size());
	}
}
