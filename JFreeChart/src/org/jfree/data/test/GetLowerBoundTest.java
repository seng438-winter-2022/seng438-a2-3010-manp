package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.jfree.data.Range;

public class GetLowerBoundTest {
private Range testR;
private Range testR2;
@Before
public void setUp() throws Exception
	{
	testR = new Range(10.0, 30.0);
	testR2 = new Range(-21.3, -20.0);
	}
@Test
public void testLowerBoundPositiveValueForMethodGetLowerBound() {
	
	assertEquals("The Lower bound value is.", 10.0, testR.getLowerBound(), .0000001d);
}

@Test
public void testLowerBoundNegativeValueForMethodGetLowerBound() {
	
	assertEquals("The Lower bound value is.", -21.3, testR2.getLowerBound(), .0000001d);
}

@After
public void tearDown()
	{
		System.out.println("Tear Down");
		testR = null;
	}

}