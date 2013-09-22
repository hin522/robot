package com.hin.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class PlaceExecutorTest {

	private PlaceExecutor executor;
	private Robot robot;
	private Table table;
	private String[] params;
	
	@Before
	public void setup() {
		robot = new Robot();
		table = new Table(5, 5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testContructorGivenNullRobotShouldFail() {
		executor = new PlaceExecutor(null, table, params);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testContructorGivenNullTableShouldFail() {
		executor = new PlaceExecutor(robot, null, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testContructorGivenTwoParametersShouldFail() {
		String[] params = {"x", "2"};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenInvalidPositionXShouldFail() {
		String[] params = {"x", "2", "EAST"};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenInvalidPositionYShouldFail() {
		String[] params = {"3", "Y", "EAST"};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenInvalidDirectionShouldFail() {
		String[] params = {"3", "3", "SomeDirection"};
		executor = new PlaceExecutor(robot, table, params);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenPositionXBeyondTableWestShouldFail() {
		String[] params = {"-1", "3", Direction.EAST.name()};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenPositionXBeyondTableEastShouldFail() {
		String[] params = {"5", "2", Direction.EAST.name()};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenPositionYBeyondTableNorthShouldFail() {
		String[] params = {"2", "5", Direction.EAST.name()};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorGivenPositionXBeyondTableSouthShouldFail() {
		String[] params = {"2", "-1", Direction.EAST.name()};
		executor = new PlaceExecutor(robot, table, params);
	}
	
	@Test
	public void testExecuteGivenValidCommandShouldSuccess() {
		String[] params = {"2", "3", Direction.EAST.name()};
		executor = new PlaceExecutor(robot, table, params);
		executor.execute();
		assertTrue(robot.isRobotOnTable());
		assertEquals(2, robot.getPosition().getCoordinateX());
		assertEquals(3, robot.getPosition().getCoordinateY());
		assertEquals(Direction.EAST, robot.getDirection());
	}

}
