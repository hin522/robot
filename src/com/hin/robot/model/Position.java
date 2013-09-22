package com.hin.robot.model;

public class Position {

	private int coordinateX;
	private int coordinateY;

	public Position(int coordinateX, int coordinateY) {
		super();
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int xCoordinate) {
		this.coordinateX = xCoordinate;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int yCoordinate) {
		this.coordinateY = yCoordinate;
	}
}
