package com.anz.rpncalculator.impl;

import java.util.List;

import com.anz.rpncalculator.RpnCalculatorCordinatorService;
import com.anz.rpncalculator.RpnCalculatorExecuteService;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.IllegalParameterException;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;
import com.anz.rpncalculator.util.CommandPool;
import com.anz.rpncalculator.util.NumberUtils;

/**
 *
 *
 */
public class RpnCalculatorExecuteServiceImpl implements RpnCalculatorExecuteService {

	private static final String IS_NUMBER_REGEX = "[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?";

	public void computeTokens(List<String> commandList, RpnStack rpnStack, int position) throws RpnCalculationException {
		for (String token : commandList) {
			rpnStack.setPosition(position);

			if (token.matches(IS_NUMBER_REGEX)) {
				rpnStack.push(NumberUtils.convertBeforeSavingInStack(token));
			} else if (CommandPool.ALLOWED_COMMANDS.get(CommandEnum.fromString(token)) != null) {
				CommandPool.ALLOWED_COMMANDS.get(CommandEnum.fromString(token)).perform(rpnStack);
			} else {
				throw new IllegalParameterException(token);
			}
		}
	}
}
