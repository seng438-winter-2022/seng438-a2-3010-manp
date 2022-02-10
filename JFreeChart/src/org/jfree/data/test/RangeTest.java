package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class RangeTest {
	/*
	 * Reference:
	 * public java.lang.String toString(): Returns a string representation of this Range.
	 * Overrides: toString in class java.lang.Object
	 * Returns: A String "Range[lower,upper]" where lower=lower range and upper=upper range.
	 */
	
	//to test ToString method within Range class
	public static class ToStringTest {
		private Range test1;
		private Range test2;
		private Range test3;
		private Range test4;
		private Range test5;
	    // Different ranges are created for testing purpose
	    @Before
	    public void setUp() throws Exception {
	    	test1 = new Range (10,30);
	    	test2 = new Range (-30, -10);
	    	test3 = new Range (10.55, 99.55);
	    	test4 = new Range (0,0);
	    }
	    // Checking to see if correct positive values that are in range are returned from toString() method	
	    @Test
	    public void testPositiveForMethodToString() {
	    	assertEquals("Range with lower 10 and upper 100, by calling toString method",
	    			"Range[10.0,30.0]", test1.toString());
	    }
	    // Checking to see if correct negative values that are in range are returned from toString() method	
	    @Test
	    public void testNegativeForMethodToString() {
	    	assertEquals("Range with lower -100 and upper -10, by calling toString method",
	    			"Range[-30.0,-10.0]", test2.toString());
	    }
	     // Checking to see if correct decimal values that are in range are returned from toString() method	
	    @Test
	    public void testTwoDecimalForMethodToString() {
	    	assertEquals("Range with lower 10.5 and upper 99.5, by calling toString method",
	    			"Range[10.55,99.55]", test3.toString());
	    }
	    // Checking to see if correct values that are in range are returned from toString() method	
	    @Test
	    public void testSameBoundForMethodToString() {
	    	assertEquals("Range with lower 0 and upper 0,by calling toString method",
	    			"Range[0.0,0.0]", test4.toString());
	    }
	    // Checking to see if empty string is returned as intended.
	    @Test
	    public void testNullForMethodToString() {
	    	boolean flag = false;
	    	try {
	    		test5.toString();
	    	}catch(Exception e) {
	    		flag = true;
	    	}
	    	assertTrue("Test with uninitialized input",flag);
	    }
	    
	    @After
	    public void tearDown() throws Exception {
	    	test1 = null;
	    	test2 = null;
	    	test3 = null;
	    	test4 = null;
	    }
	}
	
	
	/*
	 * public double getLowerBound()
	 * Returns the lower bound for the range.
	 * Returns:The lower bound.
	 */

	/* Testing GetLowerBound methods in Range class */
	public static class GetLowerBoundTest {
	private Range testR;
	private Range testR2;
	private Range testR3;
	/* Two Ranges are defined below (10.0 to 30.0 and -21.3 to -20.0) for testing purpose */
	@Before
	public void setUp() throws Exception
		{
		testR = new Range(10.0, 30.0);
		testR2 = new Range(-21.3, -20.0);
		testR3 = new Range(0.00000000001,10.0);
		}
	/* Testing to see if correct positive lower bound value is returned  */
	@Test
	public void testLowerBoundPositiveValueForMethodGetLowerBound() {
		
		assertEquals("The Lower bound value is.", 10.0, testR.getLowerBound(), .0000001d);
	}
		
	/* Testing to see if correct negative lower bound value is returned  */
	@Test
	public void testLowerBoundNegativeValueForMethodGetLowerBound() {
		
		assertEquals("The Lower bound value is.", -21.3, testR2.getLowerBound(), .0000001d);
	}

	/* Testing to see if long decimal lower bound value is correctly returned  */
	@Test
	public void testLongDecimalLowerBoundValueForMethodGetLowerBound() {
		
		assertEquals("The Lower bound value is.", 0.00000000001, testR3.getLowerBound(), .0000001d);
	}

	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
		}

	}
	
	/*
	 * getLength: public double getLength()
	 * Returns the length of the range.
	 * Returns:The length.
	 */

	/* Testing GetLength methods in Range class*/
	public static class GetLengthTestingTest {
	private Range testR;
	private Range testR2;
	private Range testR3;
	private Range testR4;
	private Range testR5;
	/* Ranges are created for testing */
	@Before
	public void setUp() throws Exception
		{
		testR = new Range(10, 30);
		testR2 = new Range (20, 20);
		testR3 = new Range (-10, -5);
		testR4 = new Range (-999999999.9999999999, 9999999999.9999999999);
		testR5 = new Range (0, 0.0000000000000000000001);
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

	/* Checking to see if getLength() positive value for very large range */
	@Test
	public void testLargeRangeForMethodGetLength() {
		double test = 999999999.9999999999 + 9999999999.9999999999;
		assertEquals("The expected length of the Range is.", test, testR4.getLength(), .0001d);
	}

	/* Checking to see if getLength() positive value for very small range */
	@Test
	public void testSmallRangeForMethodGetLength() {
		double test = 0.0000000000000000000001;
		assertEquals("The expected length of the Range is.", test, testR5.getLength(), .0001d);
	}


	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
			testR2 = null;
			testR3 = null;
			testR4 = null;
			testR5 = null;
		}

	}
	
	/*
	 * public boolean equals(java.lang.Object obj): Tests this object for equality with an arbitrary object.
	 * Overrides: equals in class java.lang.Object
	 * Parameters: obj - the object to test against (null permitted).
	 * Returns: true if the input object is an equivalent range.
	 */

	/* Testing Equals method in Range class */
	public static class EqualsTest{
		
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
	
	/*
	 * public boolean contains(double value): 
	 * Returns true if the specified value is within the range and false otherwise.
	 * Parameters: value - the value to be tested
	 * Returns: true if the range contains the specified value.
	 */

	/* Testing Contains method in Range class  */
	public static class ContainsTest {
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

	/* Testing to see when the input near the lower bound */
	@Test
	public void testLowerBoundRangeValueWithCloserValueForMethodContains() {

		assertEquals("The lower bound value close but out of Range.", false, testR.contains(9.9999999999999999999999));
	}

	/* Testing to see when the input near the upper bound */
	@Test
	public void testUpperBoundRangeValueWithCloserValueForMethodContains() {

		assertEquals("The upper bound value close but out of Range.", false, testR.contains(30.000000000000000000001));
	}

	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
		}

	}
	
	
}