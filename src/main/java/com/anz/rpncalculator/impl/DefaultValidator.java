package com.anz.rpncalculator.impl;

import java.util.List;

import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.InsufficientParameterException;
import com.anz.rpncalculator.util.CommandEnum;

/**
 *
 *
 */
public class DefaultValidator implements Validator {

	@Override
	public void validate(RpnStack rpnStack, CommandEnum cmd) throws InsufficientParameterException {
		if (rpnStack.isRpnStackEmpty()) {
			throw new InsufficientParameterException(cmd.getCmd(),
					"TTT");
		}
	}
}
