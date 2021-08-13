package com.modern.training.platform.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymbolProfile {
	private final String symbol;
	private final List<Quote> quoteList;
}
