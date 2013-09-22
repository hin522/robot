package com.hin.robot.command;

import com.hin.robot.model.Robot;

public abstract class Executor {
	
	protected Robot robot;

	public abstract void execute();
	
	public Executor(Robot robot) {
		if (robot == null) {
			throw new IllegalArgumentException("Robot cannot be null");
		}
		this.robot = robot;
	}
}
