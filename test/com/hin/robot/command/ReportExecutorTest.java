package com.hin.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Direction;
import com.hin.robot.model.Position;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class ReportExecutorTest {

	private ReportExecutor executor;
	private Robot robot;
	private PrintStream printStream;
	private ByteArrayOutputStream outContent;
	
	@Before
	public void setup() {
		robot = new Robot();
		robot.setTable(new Table(5, 5));
		robot.setPosition(new Position(3,3));
		robot.setDirection(Direction.EAST);
		outContent = new ByteArrayOutputStream();
		printStream = new PrintStream(outContent);
		executor = new ReportExecutor(robot, printStream);
	}
	
	@Test
	public void testExecuteGivenRobotNotPlacedExpectNoOutput() {
		robot.setTable(null);
		executor.execute();
		assertFalse(robot.isRobotOnTable());
		assertEquals("", outContent.toString());
	}
	
	@Test
	public void testExecuteGivenRobotOnTableExpectOutput() {
		executor.execute();
		assertEquals("Output: 3,3,EAST", outContent.toString());
	}

}
