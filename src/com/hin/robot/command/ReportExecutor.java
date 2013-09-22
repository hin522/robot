package com.hin.robot.command;

import java.io.PrintStream;

import com.hin.robot.model.Robot;

public class ReportExecutor extends Executor {

	private PrintStream out;

	public ReportExecutor(Robot robot, PrintStream out) {
		super(robot);
		this.out = out;
	}

	@Override
	public void execute() {
		if (!robot.isRobotOnTable()) {
			return;
		}
		StringBuilder sb = new StringBuilder("Output: ");
		sb.append(robot.getPosition().getCoordinateX());
		sb.append(",");
		sb.append(robot.getPosition().getCoordinateY());
		sb.append(",");
		sb.append(robot.getDirection().name());
		out.println(sb.toString());
	}
}
