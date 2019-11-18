package com.anz.rpncalculator.util;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.anz.rpncalculator.Command;
import com.anz.rpncalculator.Validator;
import com.anz.rpncalculator.impl.AddCommand;
import com.anz.rpncalculator.impl.ClearCommand;
import com.anz.rpncalculator.impl.DefaultValidator;
import com.anz.rpncalculator.impl.DivideCommand;
import com.anz.rpncalculator.impl.MultiplyCommand;
import com.anz.rpncalculator.impl.RpnCalculatorExecuteServiceImpl;
import com.anz.rpncalculator.impl.SqrtCommand;
import com.anz.rpncalculator.impl.SubtractCommand;
import com.anz.rpncalculator.impl.TwoOperandValidator;
import com.anz.rpncalculator.impl.UndoCommand;

/**
 * 
 * This class cannot be instantiated and also this class loads all validators
 * and operator commands for rest of the program. Pooling commands to reuse.
 */
public class CommandPool {

	private CommandPool() {
	}

	public static final Map<CommandEnum, Command> ALLOWED_COMMANDS;

	static {
		// this can be managed by factory pattern.
		Validator twoOperValidator = new TwoOperandValidator();
		Validator singleOperandValidator = new DefaultValidator();

		ALLOWED_COMMANDS = Stream.of(
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.ADD,
						new AddCommand(twoOperValidator)),
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.SUBTRACT,
						new SubtractCommand(twoOperValidator)),
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.MULTIPLY,
						new MultiplyCommand(twoOperValidator)),
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.DIVISION,
						new DivideCommand(twoOperValidator)),
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.SQRT,
						new SqrtCommand(singleOperandValidator)),
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.UNDO,
						new UndoCommand(singleOperandValidator, new RpnCalculatorExecuteServiceImpl())),
				new AbstractMap.SimpleImmutableEntry<CommandEnum, Command>(CommandEnum.CLEAR, new ClearCommand()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

}
