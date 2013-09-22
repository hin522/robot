package com.hin.robot.command;

import java.io.PrintStream;

import com.hin.robot.model.Command;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class ExecutorFactory {

	private static final String PLACE = "PLACE";
	private static final String MOVE = "MOVE";
	private static final String LEFT = "LEFT";
	private static final String RIGHT = "RIGHT";
	private static final String REPORT = "REPORT";

	public static Executor createExecutor(Command command, Robot robot,
			Table table, PrintStream printStream) {
		Executor executor = null;
		if (command != null) {
			switch (command.getName()) {
			case PLACE:
				executor = new PlaceExecutor(robot, table, command.getParameters());
				break;
			case MOVE:
				executor = new MoveExecutor(robot, table);
				break;
			case LEFT:
				executor = new LeftExecutor(robot);
				break;
			case RIGHT:
				executor = new RightExecutor(robot);
				break;
			case REPORT:
				executor = new ReportExecutor(robot, printStream);
				break;
			default:
				throw new IllegalArgumentException("Command not found: "
						+ command.getName());
			}
		}
		return executor;
	}
}
