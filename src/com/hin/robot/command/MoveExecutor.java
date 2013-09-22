package com.hin.robot.command;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Position;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class MoveExecutor extends Executor {

	private Table table;
	
	public MoveExecutor(Robot robot, Table table) {
		super(robot);
		this.table = table;
	}

	@Override
	public void execute() {
		if (!robot.isRobotOnTable()) {
			return;
		}
		Position position = robot.getPosition();
		if (!isFallFromTable(robot.getDirection(), position)) {
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

	private boolean isFallFromTable(Direction d, Position p) {
		boolean result = true;
		switch (d) {
		case EAST:
			if (p.getCoordinateX() + 1 < table.getLengthX()) {
				result = false;
			}
			break;
		case SOUTH:
			if (p.getCoordinateY() - 1 >= 0) {
				result = false;
			}
			break;
		case WEST:
			if (p.getCoordinateX() - 1 >= 0) {
				result = false;
			}
			break;
		case NORTH:
			if (p.getCoordinateY() + 1 < table.getLengthY()) {
				result = false;
			}
			break;
		default:
			break;
		}
		return result;
	}
}
