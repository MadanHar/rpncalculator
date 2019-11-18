package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.RpnCalculatorExecuteService;
import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;
import com.anz.rpncalculator.util.CommandEnum;

/**
 * Undo previous command.
 *
 */
public class UndoCommand extends DefaultCommand {

	private RpnCalculatorExecuteService rpnCalculatorExecuteService;

	public UndoCommand(Validator validator, RpnCalculatorExecuteService rpnCalculatorExecuteService) {
		super(validator);
		this.rpnCalculatorExecuteService = rpnCalculatorExecuteService;
	}

	@Override
	public void perform(RpnStack rpnStack) throws RpnCalculationException {
		validator.validate(rpnStack, CommandEnum.UNDO);

		// Call this twice.
		rpnStack.removeLastCommand(rpnStack.getRpnStackSize());
		rpnStack.removeLastCommand(rpnStack.getRpnStackSize() - 1);

		// clear it.
		rpnStack.clearStack();

		// re run the commands.
		// two options memory vs performance - I have chosen saving memory.
		// that is we could have used another data structure to save
		// then no need to re run the commands - performance would have been better but
		// memory is consumed.
		rpnCalculatorExecuteService.computeTokens(rpnStack.getReadOnlyCommandList(), rpnStack,rpnStack.getPosition());
	}

}

