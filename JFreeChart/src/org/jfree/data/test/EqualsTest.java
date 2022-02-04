package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.Range;
import org.junit.Test;

public class EqualsTest{
	
	private Range testR;
	
	@Before
	public void setUp() throws Exception
	{
	testR = new Range(10, 20);
	}
	@Test
	public void testingSameRangeObject() {
		Range test = new Range(10, 20);
		assertEquals("Testing a Same Range Object",true, testR.equals(test));
	}
	@Test
	public void testingDifferentRangeObject() {
		Range test = new Range(40, 50);
		assertEquals("Testing a Different Range Object",false, testR.equals(test));
	}
	
	@Test
	public void testingStringObject() {
		assertEquals("Testing a Different Object",false, testR.equals("hello"));
	}
	
	@Test
	public void testingSameLowerBoundRangeObject() {
		Range test = new Range(10, 50);
		assertEquals("Testing a Different Range Object with same lower bound",false, testR.equals(test));
	}
	
	@Test
	public void testingSameUpperBoundRangeObject() {
		Range test = new Range(0, 20);
		assertEquals("Testing a Different Range Object with same upper bound",false, testR.equals(test));
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Tear Down");
		testR = null;
	}

}
