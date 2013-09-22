package com.hin.robot.model;

public class Command {

	private static final String COMMA = ",";
	private static final String EMPTY_STRING = "";
	private static final String REGEX_SPACE = "\\s+";
	private static final String SINGLE_SPACE = " ";
	private String name;
	private String[] parameters;

	public Command(String command) {
		if (command == null || EMPTY_STRING.equals(command)) {
			throw new IllegalArgumentException("Command not specified");
		}
		String[] args = command.split(SINGLE_SPACE, 2);
		this.name = args[0];
		if (args.length > 1) {
			// remove space
			String params = args[1].replaceAll(REGEX_SPACE, EMPTY_STRING);
			this.parameters = params.split(COMMA);
		}
	}

	public String getName() {
		return name;
	}

	public String[] getParameters() {
		return parameters;
	}
}
