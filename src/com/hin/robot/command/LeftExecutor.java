package com.hin.robot.command;

import com.hin.robot.model.Robot;

public class LeftExecutor extends Executor {

	public LeftExecutor(Robot robot) {
		super(robot);
	}

	@Override
	public void execute() {
		if (robot.isRobotOnTable()) {
			robot.setDirection(robot.getDirection().turnLeft());
		}
	}
}
