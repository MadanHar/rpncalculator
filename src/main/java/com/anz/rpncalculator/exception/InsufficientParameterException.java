package com.anz.rpncalculator.exception;

/**
 * This exception shoudl be thrown when operands are less for an operator.
 *
 */
public class InsufficientParameterException extends RpnCalculationException {

	private static final long serialVersionUID = 23452L;

	public InsufficientParameterException(String operator, String position) {
		super("operator " + operator + " (position: " + position + "): insufficient parameters");
	}
}
