package com.anz.rpncalculator.util;

/**
 * 
 * Enum to manage various commands (like constants mapped to operators)
 */
public enum CommandEnum {

	ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVISION("/"), SQRT("sqrt"), CLEAR("clear"), UNDO("undo");

	private String cmd;

	CommandEnum(String cmd) {
		this.cmd = cmd;
	}

	public String getCmd() {
		return this.cmd;
	}

	public static CommandEnum fromString(String cmd) {
		for (CommandEnum b : CommandEnum.values()) {
			if (b.cmd.equalsIgnoreCase(cmd)) {
				return b;
			}
		}
		return null;
	}
}
