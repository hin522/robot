package com.hin.robot.command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class RightExecutorTest {

	private Robot robot;
	private RightExecutor executor;
	
	@Before
	public void setup() {
		robot = new Robot();
		robot.setTable(new Table(5, 5));
		executor = new RightExecutor(robot);
	}
	
	@Test
	public void testExecuteGivenRobotNotPlacedShouldDoNothing() {
		robot.setTable(null);
		executor.execute();
		assertFalse(robot.isRobotOnTable());
	}
	
	@Test
	public void testExecuteGivenEastShouldChangeToSouth() {
		robot.setDirection(Direction.EAST);
		executor.execute();
		assertTrue(robot.getDirection().pointSouth());
	}
	
	@Test
	public void testExecuteGivenSouthShouldChangeToWest() {
		robot.setDirection(Direction.SOUTH);
		executor.execute();
		assertTrue(robot.getDirection().pointWest());	
	}

	@Test
	public void testExecuteGivenWestShouldChangeToNorth() {
		robot.setDirection(Direction.WEST);
		executor.execute();
		assertTrue(robot.getDirection().pointNorth());
	}

	@Test
	public void testExecuteGivenNorthShouldChangeToEast() {
		robot.setDirection(Direction.NORTH);
		executor.execute();
		assertTrue(robot.getDirection().pointEast());
	}

}
