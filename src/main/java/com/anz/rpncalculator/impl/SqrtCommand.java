package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.InsufficientParameterException;
import com.anz.rpncalculator.util.CommandEnum;
import com.anz.rpncalculator.util.NumberUtils;

public class SqrtCommand extends DefaultCommand {

	public SqrtCommand(Validator validator) {
		super(validator);
	}

	@Override
	public void perform(RpnStack rpnStack) throws InsufficientParameterException {
		validator.validate(rpnStack, CommandEnum.SQRT);
		rpnStack.push(NumberUtils.convertBigDecBeforeSavingInStack(NumberUtils.sqrt(rpnStack.pop())));
	}

}
