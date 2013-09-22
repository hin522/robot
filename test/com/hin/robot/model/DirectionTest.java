package com.hin.robot.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DirectionTest {

	@Test
	public void testFromStringGivenEastShouldReturnEast() {
		assertEquals(Direction.EAST, Direction.formString("East"));
	}

	@Test
	public void testFromStringGivenSouthShouldReturnSouth() {
		assertEquals(Direction.EAST, Direction.formString("East"));
	}

	@Test
	public void testFromStringGivenWestShouldReturnWest() {
		assertEquals(Direction.EAST, Direction.formString("East"));
	}

	@Test
	public void testFromStringGivenNorthShouldReturnNorth() {
		assertEquals(Direction.EAST, Direction.formString("East"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromStringGivenInvalidDirectionShouldFail() {
		Direction.formString("new direction");
	}

	@Test
	public void testTurnLeftFromEastShouldReturnNorth() {
		assertTrue(Direction.EAST.turnLeft().pointNorth());
	}

	@Test
	public void testTurnLeftFromSouthShouldReturnEast() {
		assertTrue(Direction.SOUTH.turnLeft().pointEast());
	}

	@Test
	public void testTurnLeftFromWestShouldReturnSouth() {
		assertTrue(Direction.WEST.turnLeft().pointSouth());
	}

	@Test
	public void testTurnLeftFromNorthShouldReturnWest() {
		assertTrue(Direction.NORTH.turnLeft().pointWest());
	}

	@Test
	public void testTurnRightFromEastShouldReturnSouth() {
		assertTrue(Direction.EAST.turnRight().pointSouth());
	}

	@Test
	public void testTurnRightFromSouthShouldReturnWest() {
		assertTrue(Direction.SOUTH.turnRight().pointWest());
	}

	@Test
	public void testTurnRightFromWestShouldReturnNorth() {
		assertTrue(Direction.WEST.turnRight().pointNorth());
	}

	@Test
	public void testTurnRightFromNorthShouldReturnEast() {
		assertTrue(Direction.NORTH.turnRight().pointEast());
	}

	@Test
	public void testPointEast() {
		assertTrue(Direction.EAST.pointEast());
		assertFalse(Direction.SOUTH.pointEast());
		assertFalse(Direction.WEST.pointEast());
		assertFalse(Direction.NORTH.pointEast());
	}

	@Test
	public void testPointSouth() {
		assertFalse(Direction.EAST.pointSouth());
		assertTrue(Direction.SOUTH.pointSouth());
		assertFalse(Direction.WEST.pointSouth());
		assertFalse(Direction.NORTH.pointSouth());
	}

	@Test
	public void testPointWest() {
		assertFalse(Direction.EAST.pointWest());
		assertFalse(Direction.SOUTH.pointWest());
		assertTrue(Direction.WEST.pointWest());
		assertFalse(Direction.NORTH.pointWest());
	}

	@Test
	public void testPointNorth() {
		assertFalse(Direction.EAST.pointNorth());
		assertFalse(Direction.SOUTH.pointNorth());
		assertFalse(Direction.WEST.pointNorth());
		assertTrue(Direction.NORTH.pointNorth());
	}
}
