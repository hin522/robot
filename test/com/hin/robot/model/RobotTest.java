package com.hin.robot.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {

	private Robot robot;
	
	@Before
	public void setup() {
		robot = new Robot();
	}
	
	@Test
	public void testIsRobotOnTableGivenNullTableShouldReturnFalse() {
		assertFalse(robot.isRobotOnTable());
	}
	
	@Test
	public void testIsRobotOnTableGivenTableShouldReturnTrue() {
		robot.setTable(new Table(3, 3));
		assertTrue(robot.isRobotOnTable());
	}
}
