package com.anz.rpncalculator.exception;

/**
 * Top level exception class for RPNCalculator project.
 *
 */
public class RpnCalculationException extends Exception {

	private static final long serialVersionUID = 2459L;

	private final String errorMessage;

	public RpnCalculationException(String message) {
		this.errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
