package com.anz.rpncalculator;

import java.util.List;

import com.anz.rpncalculator.bean.RpnStack;
import com.anz.rpncalculator.exception.RpnCalculationException;

/**
 * This service interface holds execute method which executes all the token on to
 * stack and operation as well.
 *
 */
public interface RpnCalculatorExecuteService {
	void computeTokens(List<String> commandList, RpnStack rpnStack, int position) throws RpnCalculationException;
}
