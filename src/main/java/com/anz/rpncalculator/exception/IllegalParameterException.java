package com.anz.rpncalculator.exception;

/**
 * 
 * This exception should be thrown when an invalid token is passed in input
 * string which is not a valid number or a operator.
 */
public class IllegalParameterException extends RpnCalculationException {

	private static final long serialVersionUID = 23452L;

	public IllegalParameterException(String token) {
		super("Invalid paramater supplied to RpnCalculator: " + token);
	}
}
