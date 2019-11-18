package com.anz.rpncalculator.impl;

import java.math.BigDecimal;

import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;
import com.anz.rpncalculator.util.NumberUtils;

public class SubtractCommand extends DefaultCommand {

	public SubtractCommand(Validator validator) {
		super(validator);
	}

	@Override
	public void perform(RpnStack rpnStack) throws RpnCalculationException {
		validator.validate(rpnStack, CommandEnum.SUBTRACT);
		BigDecimal rightOperand = rpnStack.pop();
		rpnStack.push(NumberUtils.convertBigDecBeforeSavingInStack(rpnStack.pop().subtract(rightOperand)));
	}

}
