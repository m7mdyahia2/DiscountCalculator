package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) Jumia
 */
public class DiscountAmountCalculator {


	private static final List<DiscountDefinition> discountDefinitions = new ArrayList<>();

	static {

		discountDefinitions.add(new DiscountDefinition(new AmountRang(500, 700), 0.1f));
		discountDefinitions.add(new DiscountDefinition(new AmountRang(700, 1000), 0.2f));
		discountDefinitions.add(new DiscountDefinition(new AmountRang(1000, 1500), 0.3f));
		try {
			discountDefinitions.add(new DiscountDefinition(AmountRang.fromLowerLimit(1500.0f), 0.5f));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			discountDefinitions.add(new DiscountDefinition(AmountRang.fromUpperLimit(500), 0.0f));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static float getDiscountAmount(float totalAmount) {
		return discountDefinitions
				.stream()
				.filter(discountDefinition -> discountDefinition.isWithinRange(totalAmount))
				.map(DiscountDefinition::getDiscountAmount)
				.findFirst().orElseThrow(IllegalArgumentException::new);
	}

}
