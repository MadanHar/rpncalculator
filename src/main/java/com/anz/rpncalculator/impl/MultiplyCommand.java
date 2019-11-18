package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;
import com.anz.rpncalculator.util.NumberUtils;

/**
 * Multiply stragety/Command
 *
 */
public class MultiplyCommand extends DefaultCommand {

	public MultiplyCommand(Validator validator) {
		super(validator);
	}

	@Override
	public void perform(RpnStack rpnStack) throws RpnCalculationException {
		validator.validate(rpnStack, CommandEnum.MULTIPLY);
		rpnStack.push(NumberUtils.convertBigDecBeforeSavingInStack(rpnStack.pop().multiply(rpnStack.pop())));
	}

}
