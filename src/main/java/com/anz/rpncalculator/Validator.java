package com.anz.rpncalculator;

import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.InsufficientParameterException;
import com.anz.rpncalculator.util.CommandEnum;

/**
 * 
 * Validation spec which defines how validations shoud be performed for an
 * operation.
 */
public interface Validator {
	public void validate(RpnStack rpnStack, CommandEnum command) throws InsufficientParameterException;
}
