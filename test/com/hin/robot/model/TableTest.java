package com.hin.robot.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TableTest {

	@Test
	public void testConstructorWithValidLenghtsShouldSuccess() {
		Table table = new Table(5, 5);
		assertNotNull(table);
		assertEquals(5, table.getLengthX());
		assertEquals(5, table.getLengthY());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithZeroXShouldFail() {
		new Table(0, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNegativeXShouldFail() {
		new Table(-1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithZeroYShouldFail() {
		new Table(5, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNegativeYShouldFail() {
		new Table(5, -1);
	}
}
