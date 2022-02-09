package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.jfree.data.Range;

/* Testing GetLength methods in Range class*/
public class GetLengthTesting {
private Range testR;
private Range testR2;
private Range testR3;
/* Ranges are created for testing */
@Before
public void setUp() throws Exception
	{
	testR = new Range(10, 30);
	testR2 = new Range (20, 20);
	testR3 = new Range (-10, -5);
	}

/* Testing to see if expected value will be returned from getLength() for given valid input */
@Test
public void testDifferentUpperAndLowerBoundsForMethodGetLength() {

	assertEquals("The expected length of the Range is.", 20, testR.getLength(), .0001d);
}

/* Checking to see if getLength() returns the expected value for a given input */
@Test
public void testSameUpperAndLowerBoundsForMethodGetLength() {

	assertEquals("The expected length of the Range is.", 0, testR2.getLength(), .0001d);
}
/* Checking to see if getLength() positive value for negative range */
@Test
public void testNegativeUpperAndLowerBoundsForMethodGetLength() {

	assertEquals("The expected length of the Range is.", 5, testR3.getLength(), .0001d);
}
@After
public void tearDown()
	{
		System.out.println("Tear Down");
		testR = null;
	}

}
