package com.hin.robot.command;

import com.hin.robot.model.Position;
import com.hin.robot.model.Robot;

public class MoveExecutor extends Executor {

	public MoveExecutor(Robot robot) {
		super(robot);
	}

	@Override
	public void execute() {
		Position position = robot.getPosition();
		switch (robot.getDirection()) {
		case EAST:
			position.setCoordinateX(position.getCoordinateX() + 1);
			break;
		case SOUTH:
			position.setCoordinateY(position.getCoordinateY() - 1);
			break;
		case WEST:
			position.setCoordinateX(position.getCoordinateX() - 1);
			break;
		case NORTH:
			position.setCoordinateY(position.getCoordinateY() + 1);
			break;
		default:
			break;
		}
	}

}
