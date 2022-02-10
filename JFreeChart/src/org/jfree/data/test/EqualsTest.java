package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.Range;
import org.junit.Test;

/*
 * public boolean equals(java.lang.Object obj): Tests this object for equality with an arbitrary object.
 * Overrides: equals in class java.lang.Object
 * Parameters: obj - the object to test against (null permitted).
 * Returns: true if the input object is an equivalent range.
 */

/* Testing Equals method in Range class */
public class EqualsTest{
	
	private Range testR;
	
	/* The range of 10-20 is created for testing */
	@Before
	public void setUp() throws Exception
	{
	testR = new Range(10, 20);
	}
	
	/* Testing to see if the object is equal to itself */
	@Test
	public void testingSameRangeObject() {
		Range test = new Range(10, 20);
		assertEquals("Testing a Same Range Object",true, testR.equals(test));
	}
	
	/* Testing to see if the ranges are equal to the range objects */
	@Test
	public void testingDifferentRangeObject() {
		Range test = new Range(40, 50);
		assertEquals("Testing a Different Range Object",false, testR.equals(test));
	}
	
	/* Testing to see if the other types objects would be accepted by range object or not */
	@Test
	public void testingStringObject() {
		assertEquals("Testing a Different Object",false, testR.equals("hello"));
	}
	
	/* Testing to see object with same lower bound but different upper bound are equal or not */
	@Test
	public void testingSameLowerBoundRangeObject() {
		Range test = new Range(10, 50);
		assertEquals("Testing a Different Range Object with same lower bound",false, testR.equals(test));
	}
	
	
	/* Testing to see object with same higher bound but different lower bound are equal or not */
	@Test
	public void testingSameUpperBoundRangeObject() {
		Range test = new Range(0, 20);
		assertEquals("Testing a Different Range Object with same upper bound",false, testR.equals(test));
	}
	
	/* Testing to see if the input Range has close lower and upper bound */
	@Test
	public void testingCloseRangeObject() {
		Range test = new Range(9.99999999999999999, 20.00000000000000000001);
		assertEquals("Testing close Range Object",false, testR.equals(test));
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Tear Down");
		testR = null;
	}

}
