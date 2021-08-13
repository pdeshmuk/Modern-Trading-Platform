package com.modern.training.platform.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Quote {
	private final LocalDate		date;
	private final double		price;
	private final int			volume;
}
