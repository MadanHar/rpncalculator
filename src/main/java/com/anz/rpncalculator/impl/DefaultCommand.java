package com.anz.rpncalculator.impl;

import com.anz.rpncalculator.Command;
import com.anz.rpncalculator.Validator;

/**
 * 
 * Preloaded/spec for command with validator in it.
 */
public abstract class DefaultCommand implements Command {

	protected Validator validator;

	public DefaultCommand(Validator validator) {
		this.validator = validator;
	}
}
