package com.hin.robot.model;


public class Robot {

	private Position position;
	private Direction direction;
	private Table table;

	public Robot() {
	}

	public boolean isRobotOnTable() {
		return table != null;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
