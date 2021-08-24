package com.modern.training.platform.service.watchlist;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.modern.training.platform.model.Quote;
import com.modern.training.platform.model.SymbolProfile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService{

	@Override
	public SymbolProfile getSymbolProfile(String symbol, int days) {
		
		LocalDate start = LocalDate.now().minusDays(days);
		
		List<Quote> quoteList = Stream.iterate(start, d -> d.plusDays(1))
				  .limit(days)
				  .map(dt -> new Quote(dt, 1.42, 1000000))
				  .collect(Collectors.toList());

		return SymbolProfile.builder()
				.symbol(symbol)
				.quoteList(quoteList)
				.build();
	}

}
