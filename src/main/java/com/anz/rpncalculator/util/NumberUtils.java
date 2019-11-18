package com.anz.rpncalculator.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 
 * Decimal formatting and calculation related utilities.
 * 
 */
public class NumberUtils {

	private NumberUtils() {
	}

	public static BigDecimal convertBeforeSavingInStack(String val) {
		BigDecimal decimal = new BigDecimal(val, MathContext.DECIMAL128).setScale(15, RoundingMode.CEILING)
				.stripTrailingZeros();
		return new BigDecimal(decimal.toPlainString());
	}

	public static BigDecimal convertBigDecBeforeSavingInStack(BigDecimal val) {
		BigDecimal decimal = val.setScale(15, RoundingMode.CEILING).stripTrailingZeros();
		return new BigDecimal(decimal.toPlainString());
	}

	public static String convertBeforePrintingStack(BigDecimal number) {
		DecimalFormat df = new DecimalFormat("#.##########");
		return df.format(number);
	}

	/*
	 * This is a custom logic to calculate sqrt with precision upto 32 decimals.
	 * Since requirement is t have upto 20 decimals and print upto 15 decimals.
	 * 
	 * BigDecimal does not have sqrt function in java 8.
	 */
	public static BigDecimal sqrt(BigDecimal value) {
		BigDecimal x = BigDecimal.valueOf(Math.sqrt(value.doubleValue()));
		return x.add(BigDecimal.valueOf(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
	}
}
