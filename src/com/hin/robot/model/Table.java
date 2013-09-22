package com.hin.robot.model;

public class Table {

	private int lengthX;
	private int LengthY;

	public Table(int lengthX, int lengthY) {
		super();
		if (lengthX < 1) {
			throw new IllegalArgumentException(
					"lengthX must be positive number");
		}
		if (lengthY < 1) {
			throw new IllegalArgumentException(
					"lengthY must be positive number");
		}
		this.lengthX = lengthX;
		this.LengthY = lengthY;
	}

	public int getLengthX() {
		return lengthX;
	}

	public int getLengthY() {
		return LengthY;
	}
}
