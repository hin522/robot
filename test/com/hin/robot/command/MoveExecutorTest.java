package com.hin.robot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Position;
import com.hin.robot.model.Robot;

public class MoveExecutorTest {

	private Robot robot;
	private MoveExecutor executor;
	
	@Before
	public void setup() {
		robot = new Robot();		
		executor = new MoveExecutor(robot);
	}
	
	@Test
	public void givenRobotNotOnTableEdgeFacingEastMoveShouldSuccess() {
		robot.setPosition(new Position(2, 2));
		robot.setDirection(Direction.EAST);
		executor.execute();
		assertEquals(Direction.EAST, robot.getDirection());
		assertEquals(3, robot.getPosition().getCoordinateX());
		assertEquals(2, robot.getPosition().getCoordinateY());
	}
	
	@Test
	public void givenRobotNotOnTableEdgeFacingSouthMoveShouldSuccess() {
		robot.setPosition(new Position(2, 2));
		robot.setDirection(Direction.SOUTH);
		executor.execute();
		assertEquals(Direction.SOUTH, robot.getDirection());
		assertEquals(2, robot.getPosition().getCoordinateX());
		assertEquals(1, robot.getPosition().getCoordinateY());
	}

	@Test
	public void givenRobotNotOnTableEdgeFacingWestMoveShouldSuccess() {
		robot.setPosition(new Position(2, 2));
		robot.setDirection(Direction.WEST);
		executor.execute();
		assertEquals(Direction.WEST, robot.getDirection());
		assertEquals(1, robot.getPosition().getCoordinateX());
		assertEquals(2, robot.getPosition().getCoordinateY());
	}
	
	@Test
	public void givenRobotNotOnTableEdgeFacingNorthMoveShouldSuccess() {
		robot.setPosition(new Position(2, 2));
		robot.setDirection(Direction.NORTH);
		executor.execute();
		assertEquals(Direction.NORTH, robot.getDirection());
		assertEquals(2, robot.getPosition().getCoordinateX());
		assertEquals(3, robot.getPosition().getCoordinateY());
	}
	
}
