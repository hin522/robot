package com.hin.robot.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CommandTest {

	@Test(expected=IllegalArgumentException.class)
	public void testCommandWithNullStringShouldFalse() {
		new Command(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCommandWithEmptyStringShouldFalse() {
		new Command("");
	}
	
	@Test
	public void testCommandWithoutParameters() {
		Command command = new Command("PLACE");
		assertEquals("PLACE", command.getName());
		assertNull(command.getParameters());
	}

	@Test
	public void testCommandWithOneParameter() {
		Command command = new Command("PLACE p1");
		assertEquals("PLACE", command.getName());
		assertEquals(1, command.getParameters().length);
		assertEquals("p1", command.getParameters()[0]);
	}

	@Test
	public void testCommandWithThreeParameters() {
		Command command = new Command("PLACE p1, p2, p3");
		assertEquals("PLACE", command.getName());
		assertEquals(3, command.getParameters().length);
		assertEquals("p1", command.getParameters()[0]);
		assertEquals("p2", command.getParameters()[1]);
		assertEquals("p3", command.getParameters()[2]);
	}
}
