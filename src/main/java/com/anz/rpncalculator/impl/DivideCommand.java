package com.anz.rpncalculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.IllegalParameterException;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;

/**
 * 
 * Divide Strategy/Command
 */
public class DivideCommand extends DefaultCommand {

	public DivideCommand(Validator validator) {
		super(validator);
	}

	@Override
	public void perform(RpnStack rpnStack) throws RpnCalculationException {
		validator.validate(rpnStack, CommandEnum.DIVISION);
		BigDecimal divisor = rpnStack.pop();
		if (divisor.doubleValue() == 0) {
			throw new IllegalParameterException(divisor.toString());
		}

		rpnStack.push(rpnStack.pop().divide(divisor, 15, RoundingMode.CEILING).stripTrailingZeros());
	}

}
