package com.hin.robot.command;

import com.hin.robot.model.Robot;

public class RightExecutor extends Executor {

	public RightExecutor(Robot robot) {
		super(robot);
	}

	@Override
	public void execute() {
		if (robot.isRobotOnTable()) {
			robot.setDirection(robot.getDirection().turnRight());
		}
	}
}
