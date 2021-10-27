package com.company;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright (c) Jumia
 */
@Data
@AllArgsConstructor
public class DiscountDefinition {
	private AmountRang amountRang;
	private float discountAmount;

	public boolean isWithinRange(float amount) {
		return amount >= amountRang.getFrom() && amount < amountRang.getTo();
	}
}
