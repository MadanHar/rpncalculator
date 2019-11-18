package com.anz.rpncalculator;

import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;

/**
 * General contract for commands like subtraction, addition, division and etc
 * 
 */
public interface Command {
	void perform(RpnStack rpnStack) throws RpnCalculationException;
}
