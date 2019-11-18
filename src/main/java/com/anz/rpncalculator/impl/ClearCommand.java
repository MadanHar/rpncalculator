package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.Command;
import com.anz.rpncalculator.bean.RpnStack;

/**
 * 
 * Clear Strategy /Command.
 */
public class ClearCommand implements Command {

	@Override
	public void perform(RpnStack rpnStack) {
		rpnStack.clearStack();
	}

}
