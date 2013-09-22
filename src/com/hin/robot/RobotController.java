package com.hin.robot;

import java.io.PrintStream;
import java.util.List;

import com.hin.robot.command.ExecutorFactory;
import com.hin.robot.io.CommandReader;
import com.hin.robot.io.FileCommandReader;
import com.hin.robot.model.Command;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class RobotController {

	private static final int TABLE_LENGTH_X = 5;
	private static final int TABLE_LENGTH_Y = 5;
	
	private static final String COMMAND_INPUT_FILE = "resource/input.txt";
	private Robot robot;
	private Table table;
	private PrintStream printStream;
	
	public RobotController() {
		robot = new Robot();
		table = new Table(TABLE_LENGTH_X, TABLE_LENGTH_Y);
		printStream = System.out;
	}
	
	public void on() {
		CommandReader reader = new FileCommandReader(COMMAND_INPUT_FILE);
		List<Command> commands = reader.readCommands();

		for (Command command : commands) {
			ExecutorFactory.createExecutor(command, robot, table, printStream).execute();
		}
	}
}
