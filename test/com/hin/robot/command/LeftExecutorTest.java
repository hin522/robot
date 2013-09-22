package com.hin.robot.command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class LeftExecutorTest {

	private Robot robot;
	private LeftExecutor executor;
	
	@Before
	public void setup() {
		robot = new Robot();
		robot.setTable(new Table(5,5));
		executor = new LeftExecutor(robot);
	}
	
	@Test
	public void testExecuteGivenRobotNotPlacedShouldDoNothing() {
		robot.setTable(null);
		executor.execute();
		assertFalse(robot.isRobotOnTable());
	}
	
	@Test
	public void testExecuteGivenEastShouldChangeToNorth() {
		robot.setDirection(Direction.EAST);
		executor.execute();
		assertTrue(robot.getDirection().pointNorth());
	}
	
	@Test
	public void testExecuteGivenSouthShouldChangeToEast() {
		robot.setDirection(Direction.SOUTH);
		executor.execute();
		assertTrue(robot.getDirection().pointEast());	
	}

	@Test
	public void testExecuteGivenWestShouldChangeToSouth() {
		robot.setDirection(Direction.WEST);
		executor.execute();
		assertTrue(robot.getDirection().pointSouth());
	}

	@Test
	public void testExecuteGivenNorthShouldChangeToWest() {
		robot.setDirection(Direction.NORTH);
		executor.execute();
		assertTrue(robot.getDirection().pointWest());
	}

}
