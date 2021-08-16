package com.modern.training.platform.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymbolProfile {
	
	private final String symbol;
	private final List<Quote> quoteList;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public SymbolProfile(@JsonProperty("symbol") String symbol, @JsonProperty("quoteList") List<Quote> quoteList) {
	    this.symbol = symbol;
	    this.quoteList = quoteList;
	}
}
