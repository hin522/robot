package com.hin.robot.command;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.hin.robot.model.Command;
import com.hin.robot.model.Robot;
import com.hin.robot.model.Table;

public class ExecutorFactoryTest {

	private Command command;
	private Robot robot;
	private Table table;
	private PrintStream printStream;
	
	@Before
	public void setup() {
		robot = new Robot();
		table = new Table(5, 5);		
		printStream = System.out;
	}
	
	@Test
	public void givenEmptyCommandShouldReturnNull() {
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertNull(executor);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenInvalidCommandNameShouldReturnFalse() {
		command = new Command("NewCommand 2, 3, EAST");
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertNull(executor);
	}
	
	@Test
	public void givenPlaceCommandShouldReturnPlaceExecutor() {
		command = new Command("PLACE 2, 3, EAST");
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertTrue(executor instanceof PlaceExecutor);
	}

	@Test
	public void givenMoveCommandShouldReturnMoveExecutor() {
		command = new Command("MOVE");
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertTrue(executor instanceof MoveExecutor);
	}
	
	@Test
	public void givenLeftCommandShouldReturnLeftExecutor() {
		command = new Command("LEFT");
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertTrue(executor instanceof LeftExecutor);
	}
	
	@Test
	public void givenRightCommandShouldReturnRightExecutor() {
		command = new Command("RIGHT");
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertTrue(executor instanceof RightExecutor);
	}
	
	@Test
	public void givenReportCommandShouldReturnReportExecutor() {
		command = new Command("REPORT");
		Executor executor = ExecutorFactory.createExecutor(command, robot, table, printStream);
		assertTrue(executor instanceof ReportExecutor);
	}

}
