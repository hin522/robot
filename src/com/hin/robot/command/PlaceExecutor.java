package com.hin.robot.command;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Position;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class PlaceExecutor extends Executor {

	private Table table;
	private Position position;
	private Direction direction;
	
	public PlaceExecutor(Robot robot, Table table, String[] parameters) {
		super(robot);
		if (table == null) {
			throw new IllegalArgumentException("Table is not initialised");
		}
		
		if (parameters.length != 3) {
			throw new IllegalArgumentException("Number of argument must be 3");
		}
		
		Position position = createPosition(parameters[0], parameters[1]);		
		Direction direction = createDirection(parameters[2]);

		validatePositionOnTable(table, position);
		
		this.table = table;
		this.position = position;
		this.direction = direction;
	}

	@Override
	public void execute() {
		robot.setTable(table);
		robot.setPosition(position);
		robot.setDirection(direction);
	}
	
	private Position createPosition(String x, String y) {
		int xCoordinate=0;
		int yCoordinate=0;
		try {
			xCoordinate = Integer.parseInt(x);
			yCoordinate = Integer.parseInt(y);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Coordinate is not a number");
		}
		return new Position(xCoordinate, yCoordinate);
	}
	
	private Direction createDirection(String d) {
		return Direction.formString(d);
	}
	
	private void validatePositionOnTable(Table t, Position p) {
		if (p.getCoordinateX() < 0 || 
				p.getCoordinateY() < 0 ||
				p.getCoordinateX() >= t.getLengthX() || 
				p.getCoordinateY() >= t.getLengthY()) {
			throw new IllegalArgumentException("Invalid coordinate on table");
		}
	}

}
