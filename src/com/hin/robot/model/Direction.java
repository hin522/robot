package com.hin.robot.model;

public enum Direction {

	EAST("EAST"), SOUTH("SOUTH"), WEST("WEST"), NORTH("NORTH");

	private String point;

	private Direction(String p) {
		point = p;
	}

	public String getPoint() {
		return point;
	}

	public static Direction formString(String direction) {
		if (direction != null) {
			for (Direction d : Direction.values()) {
				if (direction.equalsIgnoreCase(d.getPoint())) {
					return d;
				}
			}
		}
		throw new IllegalArgumentException("Direction is invalid: " +direction);
	}

	public Direction turnLeft() {
		Direction directions[] = Direction.values();
		int ordinal = this.ordinal();
		ordinal = ordinal == 0 ? directions.length - 1 : --ordinal;
		return directions[ordinal];
	}

	public Direction turnRight() {
		Direction directions[] = Direction.values();
		int ordinal = this.ordinal();
		ordinal = ++ordinal % directions.length;
		return directions[ordinal];
	}

	public boolean pointEast() {
		return EAST.equals(this);
	}

	public boolean pointSouth() {
		return SOUTH.equals(this);
	}

	public boolean pointWest() {
		return WEST.equals(this);
	}

	public boolean pointNorth() {
		return NORTH.equals(this);
	}
}
