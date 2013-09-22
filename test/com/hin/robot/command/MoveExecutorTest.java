package com.hin.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Position;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class MoveExecutorTest {

	private Robot robot;
	private Table table;
	private MoveExecutor executor;
	
	@Before
	public void setup() {
		robot = new Robot();		
		table = new Table(5, 5);
		robot.setTable(table);
		executor = new MoveExecutor(robot, table);
	}
	
	@Test
	public void testExecuteGivenRobotNotPlacedShouldDoNothing() {
		robot.setTable(null);
		executor.execute();
		assertFalse(robot.isRobotOnTable());
	}
	
	@Test
	public void givenRobotOnEastTableEdgeFacingEastMoveShouldRemainAtSamePosition() {
		robot.setPosition(new Position(4, 2));
		robot.setDirection(Direction.EAST);
		executor.execute();
		assertEquals(Direction.EAST, robot.getDirection());
		assertEquals(4, robot.getPosition().getCoordinateX());
		assertEquals(2, robot.getPosition().getCoordinateY());	
	}
	
	@Test
	public void givenRobotOnSouthTableEdgeFacingSouthMoveShouldRemainAtSamePosition() {
		robot.setPosition(new Position(2, 0));
		robot.setDirection(Direction.SOUTH);
		executor.execute();
		assertEquals(Direction.SOUTH, robot.getDirection());
		assertEquals(2, robot.getPosition().getCoordinateX());
		assertEquals(0, robot.getPosition().getCoordinateY());	
	}
	
	@Test
	public void givenRobotOnWestTableEdgeFacingWestMoveShouldRemainAtSamePosition() {
		robot.setPosition(new Position(0, 2));
		robot.setDirection(Direction.WEST);
		executor.execute();
		assertEquals(Direction.WEST, robot.getDirection());
		assertEquals(0, robot.getPosition().getCoordinateX());
		assertEquals(2, robot.getPosition().getCoordinateY());	
	}
	
	@Test
	public void givenRobotOnNorthTableEdgeFacingNorthMoveShouldRemainAtSamePosition() {
		robot.setPosition(new Position(2, 4));
		robot.setDirection(Direction.NORTH);
		executor.execute();
		assertEquals(Direction.NORTH, robot.getDirection());
		assertEquals(2, robot.getPosition().getCoordinateX());
		assertEquals(4, robot.getPosition().getCoordinateY());	
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
