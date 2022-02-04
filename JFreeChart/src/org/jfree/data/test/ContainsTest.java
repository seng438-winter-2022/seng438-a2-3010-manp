package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.jfree.data.Range;

public class ContainsTest {
private Range testR;
@Before
public void setUp() throws Exception
	{
	testR = new Range(10.0, 30.0);
	}
@Test
public void testValueInRangeForMethodContains() {
	

	assertEquals("The value lies in Range.", true, testR.contains(20.0));
}

@Test
public void testValueLessThanLowerBoundForMethodContains() {

	assertEquals("The value is less than lower bound range value and does not lie in Range.", false, testR.contains(-10.0));
}

@Test
public void testValueMoreThanUpperBoundForMethodContains() {

	assertEquals("The value is more than upper bound range value and does not lie in Range.", false, testR.contains(40.0));
}


@Test
public void testLowerBoundRangeValueForMethodContains() {

	assertEquals("The lower bound value lies in Range.", true, testR.contains(10.0));
}

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