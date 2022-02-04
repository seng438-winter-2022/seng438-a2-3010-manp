package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.jfree.data.Range;

public class GetLengthTesting {
private Range testR;
private Range testR2;
private Range testR3;
@Before
public void setUp() throws Exception
	{
	testR = new Range(10, 30);
	testR2 = new Range (20, 20);
	testR3 = new Range (-10, -5);
	}
@Test
public void testDifferentUpperAndLowerBoundsForMethodGetLength() {

	assertEquals("The expected length of the Range is.", 20, testR.getLength(), .0001d);
}

@Test
public void testSameUpperAndLowerBoundsForMethodGetLength() {

	assertEquals("The expected length of the Range is.", 0, testR2.getLength(), .0001d);
}

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
