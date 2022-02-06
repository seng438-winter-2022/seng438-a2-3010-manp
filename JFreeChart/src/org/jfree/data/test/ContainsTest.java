package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.jfree.data.Range;

public class ContainsTest {
private Range testR;

/* The range of 10.0-30.0 is created for testing */
@Before
public void setUp() throws Exception
	{
	testR = new Range(10.0, 30.0);
	}
/* Testing to see if range contains a number in between the upper and the lower bound */
@Test
public void testValueInRangeForMethodContains() {
	

	assertEquals("The value lies in Range.", true, testR.contains(20.0));
}
/* Testing to see if range contains a number that is less than the lower bound */
@Test
public void testValueLessThanLowerBoundForMethodContains() {

	assertEquals("The value is less than lower bound range value and lies inside Range.", false, testR.contains(-10.0));
}
/* Testing to see if range contains a number that is higher than the upper bound */
@Test
public void testValueMoreThanUpperBoundForMethodContains() {

	assertEquals("The value is more than upper bound range value and lies inside Range.", false, testR.contains(40.0));
}

/* Testing to see if range contains the lower bound */
@Test
public void testLowerBoundRangeValueForMethodContains() {

	assertEquals("The lower bound value lies in Range.", true, testR.contains(10.0));
}
/* Testing to see if range contains the upper bound */
@Test
public void testUpperBoundRangeValueForMethodContains() {

	assertEquals("The upper bound value lies in Range.", true, testR.contains(30.0));
}

@After
public void tearDown()
	{
		System.out.println("Tear Down");
		testR = null;
	}

}
