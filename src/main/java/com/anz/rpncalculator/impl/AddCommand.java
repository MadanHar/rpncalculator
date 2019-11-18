package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;
import com.anz.rpncalculator.util.NumberUtils;

/**
 * 
 * Addition strategy/command
 */
public class AddCommand extends DefaultCommand {

	public AddCommand(Validator validator) {
		super(validator);
	}

	@Override
	public void perform(RpnStack rpnStack) throws RpnCalculationException {
		validator.validate(rpnStack, CommandEnum.ADD);
		rpnStack.push(NumberUtils.convertBigDecBeforeSavingInStack(rpnStack.pop().add(rpnStack.pop())));
	}

}
