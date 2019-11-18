package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.RpnCalculatorCordinatorService;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.InsufficientParameterException;
import com.anz.rpncalculator.util.CommandEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This validator inherits Default validator to reuse the common validation
 * logic.
 *
 */
public class TwoOperandValidator extends DefaultValidator {

	@Override
	public void validate(RpnStack rpnStack, CommandEnum cmd) throws InsufficientParameterException {
		super.validate(rpnStack, cmd);

		if (rpnStack.getRpnStackSize() < 2) {
			throw new InsufficientParameterException(cmd.getCmd(),
                getCharacterAtPosition(rpnStack.getPosition()) + " "+ rpnStack.getPosition());
		}
	}

    private String getCharacterAtPosition(int position) {
        String commandLine = RpnCalculatorCordinatorService.previousCommands.get(RpnCalculatorCordinatorService.previousCommands.size() -1);
        return String.valueOf(commandLine.charAt(position));
    }

}
