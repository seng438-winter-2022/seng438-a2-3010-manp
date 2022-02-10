package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DataUtilitiesTest {

	public static class CalculateColumnTotalTest {
		Mockery context;
		
	    @Before
	    public void setUp() throws Exception {
	    	context = new Mockery();
	    }
	    
	    /*
	     * Testing the exception thrown when null parameter is passed
	     */
	    @Rule
	    public ExpectedException thrown= ExpectedException.none();
	    
	    @Test
	    public void passingNullAsParameter() {
	    	thrown.expect(IllegalArgumentException.class);
	    	DataUtilities.calculateColumnTotal(null, 0);
	    }
		
	    /*
	     * Testing the boundary value of 32 bit signed int and adding another number to check for overflow
	     */
	    
		@Test
		public void intBoundaryValues() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(2147483647));
		            one(values).getValue(1, 0);
		            will(returnValue(100));
		            one(values).getValue(2, 0);
		            will(returnValue(-2147483648));
		        }
		    });
		    
		   double result = DataUtilities.calculateColumnTotal(values, 0);
		   assertEquals("Adding 3 rows with 32 bit signed values", 99, result, .000000001d);
		}
		
		/*
		 * Testing the column total for both positive and negative values
		 */
		
		@Test
		public void positiveNegativeColumnValues() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(4));
		            one(values).getValue(0, 0);
		            will(returnValue(-5.000005));
		            one(values).getValue(1, 0);
		            will(returnValue(5.000005));
		            one(values).getValue(2, 0);
		            will(returnValue(30.000055));
		            one(values).getValue(3, 0);
		            will(returnValue(-30.000055));
		        }
		    });
		    
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		   assertEquals("Adding 4 columns with positive and negative values",result, 0, .000000001d);
		}
		
		//first input invalid
		@Test
		public void invalidFirstInputTest(){
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(0));
		        }
		    });
		    
		    double result = DataUtilities.calculateColumnTotal(values, 5);
		    assertEquals("Input an empty Values2D object",result, 0, .000000001d);  
		}
		
		//second input invalid
		@Test
		public void invalidSecondInputTest() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(0));
		        }
		    });
		    double result = DataUtilities.calculateColumnTotal(values, -1);
		    assertEquals("Input an invalid second input",result, 0, .000000001d);
		}
		
		@Test
		public void NullColumnValueTest() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		        	one(values).getRowCount();
		            will(returnValue(4));
		            one(values).getValue(0, 0);
		            will(returnValue(null));
		            one(values).getValue(1, 0);
		            will(returnValue(null));
		            one(values).getValue(2, 0);
		            will(returnValue(null));
		            one(values).getValue(3, 0);
		            will(returnValue(null));
		        }
		    });
		   
		   double result = DataUtilities.calculateColumnTotal(values, 0);
		   assertEquals("Input Values2D object contains null value",0, result, .000000001d);
		}
		
	    @After
	    public void tearDown() throws Exception {
	    	context = null;
	    }

	}
	
	
	
	/*
	 * *****************************Row Total tests************************************
	 */
	public static class CalculateRowTotalTest {
		Mockery context;
		
	    @Before
	    public void setUp() throws Exception {
	    	context = new Mockery();
	    }
	    
	    @Rule
	    public ExpectedException thrown= ExpectedException.none();
	    
	    /*
	     * Testing the exception thrown when null parameter is passed
	     */
	    @Test
	    public void passingNullAsParameter() {
	    	thrown.expect(IllegalArgumentException.class);
	    	DataUtilities.calculateRowTotal(null, 0);
	    }
		
	    /*
	     * Testing the boundary value of 32 bit signed int and adding another number to check for overflow
	     */
		@Test
		public void intBoundaryValues() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(2147483647));
		            one(values).getValue(0, 1);
		            will(returnValue(100));
		            one(values).getValue(0, 2);
		            will(returnValue(-2147483648));;
		        }
		    });
		    
		    double result = DataUtilities.calculateRowTotal(values, 0);
		   assertEquals("Adding 4 rows with 32 bit signed values", 99 , result , .000000001d);
		}
		
		
		/*
		 * Testing the column total for both positive and negative values
		 */
		@Test
		public void positiveNegativeRowValues() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(4));
		            one(values).getValue(0, 0);
		            will(returnValue(-5.000005));
		            one(values).getValue(0, 1);
		            will(returnValue(5.000005));
		            one(values).getValue(0, 2);
		            will(returnValue(30.000055));
		            one(values).getValue(0, 3);
		            will(returnValue(-30.000055));
		        }
		    });
		   
		   double result = DataUtilities.calculateRowTotal(values, 0);
		   assertEquals("Adding 4 rows with positive and negative values",0, result, .000000001d);
		}
		
		//first input invalid
		@Test
		public void invalidFirstInputTest(){
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(0));
		        }
		    });
		    
		    double result = DataUtilities.calculateRowTotal(values, 5);
		    assertEquals("Input an empty Values2D object",result, 0, .000000001d);  
		}
		
		//second input invalid
		@Test
		public void invalidSecondInputTest() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(0));
		        }
		    });
		    double result = DataUtilities.calculateRowTotal(values, -1);
		    assertEquals("Input an invalid second input",result, 0, .000000001d);
		}
		
		@Test
		public void NullRowValueTest() {
			final Values2D values = context.mock(Values2D.class);
		    context.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(4));
		            one(values).getValue(0, 0);
		            will(returnValue(null));
		            one(values).getValue(0, 1);
		            will(returnValue(null));
		            one(values).getValue(0, 2);
		            will(returnValue(null));
		            one(values).getValue(0, 3);
		            will(returnValue(null));
		        }
		    });
		   
		   double result = DataUtilities.calculateRowTotal(values, 0);
		   assertEquals("Input Values2D object contains null value",0, result, .000000001d);
		}
		
	    @After
	    public void tearDown() throws Exception {
	    	context = null;
	    }

	}
	
	/*
	 * ********************************Create Number Array****************************
	 */
	
	public static class CreateNumberArrayTest extends DataUtilities {
		
		final double[] input = {10.005, 20.0, 30.095};
		final double[] input2 = {-10.005, -20.0, -30.095};
		final double[] input3 = {};
		
		final Number[] result = {10.005, 20.0, 30.095};
		final Number[] result2 = {-10.005, -20.0, -30.095};
		final Number[] result3 = {};

		@Before
		public void setup() {

		}
		
	    @Rule
	    public ExpectedException thrown= ExpectedException.none();
	    
	    /*
	     * Testing the exception thrown when null parameter is passed
	     */
	    @Test
	    public void passingNullAsParameter() {
	    	thrown.expect(IllegalArgumentException.class);
	    	DataUtilities.createNumberArray(null);
	    }
		
	    /*
	     * Testing the exception thrown when null parameter is passed
	     */
	    
	    @Test
	    public void CreatingNumberArrayFromEmptyArray() {
	 	   assertArrayEquals("Number array do not correspond to double array",result3 , DataUtilities.createNumberArray(input3));
	    }
	    
	    /*
	     * Testing the input of positive values
	     */
	    @Test
	    public void CreatingNumberArrayPositiveValues() {
	 	   assertArrayEquals("Number array do not correspond to double array",result, DataUtilities.createNumberArray(input));
	    }
	    
	    /*
	     * Testing the input of negative values
	     */
	    @Test
	    public void CreatingNumberArrayNegativeValues() {
	 	   assertArrayEquals("Number array do not correspond to double array",result2, DataUtilities.createNumberArray(input2));
	    }
	    
	    @After
	    public void tearDown() throws Exception {
	    	
	    }

	}
	
	
	/*
	 * ***************************Number array 2d*****************************
	 */
	
	public static class CreateNumberArray2DTest {

		private double[][] arrDouble1 = {};
		private double[][] arrDouble2 = {{1.0,2.0,3.0},
										{4.0,5.0,6.0},
										{7.0,8.0,9.0}};
		private double[][] arrDouble3 = {{-1.0,-2.0,-3.0},
										{-4.0,-5.0,-6.0},
										{-7.0,-8.0,-9.0}};
		private Number[][] arrNumber1 = {};
		private Number[][] arrNumber2 = {{1.0,2.0,3.0},
										{4.0,5.0,6.0},
										{7.0,8.0,9.0}};
		private Number[][] arrNumber3 = {{-1.0,-2.0,-3.0},
										{-4.0,-5.0,-6.0},
										{-7.0,-8.0,-9.0}};
		
		  @Before
		    public void setUp() throws Exception {
		     
		    }
		  
		  /*This test checks whether the CreateNumberArray2D receives the null parameter
		   * and when it receives the null parameter, it should throw an exception of Invalid Parameter
		   * */
		 @Test
		    public void TestNullForMethodCreateNumberArray2D(){
		    	boolean flag = false;
		    	try {
		    		DataUtilities.createNumberArray2D(null);
		    		fail("Null is not allowed as a parameter");
		    	}catch(Exception e){
		    		flag = true;
		    	}
		    	assertTrue("Test with null argument",flag);
		    }
		 /*
		  * This test checks when the double 2D empty Array passed to the testing method, it should 
		  * produce an equivalent Number 2D empty array with equal length.
		  * */
		 @Test
		 public void TestEmptyDoubleArrayForMethodCreateNumberArray2D()
		 {
			assertArrayEquals("The Number 2D array and the Double 2D array are not equivalent", arrNumber1, DataUtilities.createNumberArray2D(arrDouble1));
		 }
		 
		 /*
		  * This test checks when the double 2D Array passed to the testing method, it should 
		  * produce an equivalent Number 2D array with equal length.
		  * */
		 
		 @Test
		 public void TestDoubleArrayForMethodCreateNumberArray2D()
		 {
			assertArrayEquals("The Number 2D array and the Double 2D array are not equivalent", arrNumber2, DataUtilities.createNumberArray2D(arrDouble2));
		 }
		 
		 /*
		  * This test checks when the double 2D Array with negative value passed to the testing method, it should 
		  * produce an equivalent Number 2D array with equal length.
		  * */
		 
		 @Test
		 public void TestNegativeDoubleArrayForMethodCreateNumberArray2D()
		 {
			assertArrayEquals("The Number 2D array and the Double 2D array are not equivalent", arrNumber3, DataUtilities.createNumberArray2D(arrDouble3));
		 }
		 
		 
		 @After  
		 public void tearDown() throws Exception {
		  }

	}
	
	
	//to test getCumulatvePercentages method within DataUtilities class

	/*
	 * public static KeyedValues getCumulativePercentages(KeyedValues data):
	 * Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance. The cumulative percentage is each value's cumulative sum's portion of the sum of all the values. 
	 * eg: Input:
	 *			Key  Value
	 *			0        5
	 *			1        9
	 *			2        2
	 *	   Returns:
	 *	   		Key  Value
	 *	   		0     0.3125 (5 / 16)
	 *	   		1     0.875 ((5 + 9) / 16)
	 *	   		2     1.0 ((5 + 9 + 2) / 16)
	 * The percentages are values between 0.0 and 1.0 (where 1.0 = 100%).
	 * Parameters:data - the data (null not permitted).
	 * Returns: The cumulative percentages.
	 * Throws:InvalidParameterException - if invalid data object is passed in. 
	 */
	public static class GetCumulativePercentagesTest {
		Mockery mockingContext;
		Mockery mockingContext2;
		
	    @Before
	    public void setUp() throws Exception {
	    	mockingContext = new Mockery();
	    	mockingContext2 = new Mockery();
	    }

	    //A test to pass null object as an argument to see if method can correctly throws an exception
	    @Test
	    public void TestExceptionForMethodGetCumulativePercentages(){
	    	boolean flag = false;
	    	try {
	    		DataUtilities.getCumulativePercentages(null);
	    		fail("Null is not allowed as a parameter");
	    	}catch(Exception e){
	    		flag = true;
	    	}
	    	assertTrue("Test with null argument",flag);
	    }
	    
	    //A test use all positive key and value within KeyedValues object to see if method can work correctly
	    @Test
	    public void TestPositiveForMethodGetCumulativePercentages() {
	    	final KeyedValues input = mockingContext.mock(KeyedValues.class);
	    	mockingContext.checking(new Expectations(){
	    		{
	        		atLeast(1).of(input).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(input).getKey(0);
	        		will(returnValue(0));
	        		atLeast(1).of(input).getKey(1);
	        		will(returnValue(1));
	        		atLeast(1).of(input).getKey(2);
	        		will(returnValue(2));
	        		
	        		atLeast(1).of(input).getValue(0);
	        		will(returnValue(5));
	        		atLeast(1).of(input).getValue(1);
	        		will(returnValue(9));
	        		atLeast(1).of(input).getValue(2);
	        		will(returnValue(2));
	        		
	    		}
	    	});
	    	
	    	final KeyedValues output = mockingContext2.mock(KeyedValues.class);
	    	mockingContext2.checking(new Expectations(){
	    		{
	        		atLeast(1).of(output).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(output).getKey(0);
	        		will(returnValue(0));
	        		atLeast(1).of(output).getKey(1);
	        		will(returnValue(1));
	        		atLeast(1).of(output).getKey(2);
	        		will(returnValue(2));
	        		
	        		atLeast(1).of(output).getValue(0);
	        		will(returnValue(5/16));
	        		atLeast(1).of(output).getValue(1);
	        		will(returnValue((5+9)/16));
	        		atLeast(1).of(output).getValue(2);
	        		will(returnValue((5+9+2)/16));
	        		
	    		}
	    	});
	    	assertEquals("testing with all positive values", true, DataUtilities.getCumulativePercentages(input).equals(output));
	    }
	    
	  //A test use all negative key and value within KeyedValues object to see if method can work correctly
	    @Test
	    public void TestNegativeForMethodGetCumulativePercentages() {
	    	final KeyedValues input = mockingContext.mock(KeyedValues.class);
	    	mockingContext.checking(new Expectations(){
	    		{
	        		atLeast(1).of(input).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(input).getKey(0);
	        		will(returnValue(0));
	        		atLeast(1).of(input).getKey(1);
	        		will(returnValue(-1));
	        		atLeast(1).of(input).getKey(2);
	        		will(returnValue(-2));
	        		
	        		atLeast(1).of(input).getValue(0);
	        		will(returnValue(-10));
	        		atLeast(1).of(input).getValue(1);
	        		will(returnValue(-20));
	        		atLeast(1).of(input).getValue(2);
	        		will(returnValue(-30));
	        		
	    		}
	    	});
	    	
	    	final KeyedValues output = mockingContext2.mock(KeyedValues.class);
	    	mockingContext2.checking(new Expectations(){
	    		{
	        		atLeast(1).of(output).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(output).getKey(0);
	        		will(returnValue(0));
	        		atLeast(1).of(output).getKey(1);
	        		will(returnValue(-1));
	        		atLeast(1).of(output).getKey(2);
	        		will(returnValue(-2));
	        		
	        		atLeast(1).of(output).getValue(0);
	        		will(returnValue(-10/-60));
	        		atLeast(1).of(output).getValue(1);
	        		will(returnValue(-30/-60));
	        		atLeast(1).of(output).getValue(2);
	        		will(returnValue(-60/-60));
	        		
	    		}
	    	});
	    	assertEquals("testing with all negative values", true, DataUtilities.getCumulativePercentages(input).equals(output));
	    }
	    
	    //A test use both positive, negative and different decimal number to see if method can work correctly
	    @Test
	    public void TestMixForMethodGetCumulativePercentages() {
	    	final KeyedValues input = mockingContext.mock(KeyedValues.class);
	    	mockingContext.checking(new Expectations(){
	    		{
	        		atLeast(1).of(input).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(input).getKey(0);
	        		will(returnValue(1.0));
	        		atLeast(1).of(input).getKey(1);
	        		will(returnValue(1.1));
	        		atLeast(1).of(input).getKey(2);
	        		will(returnValue(1.2));
	        		
	        		atLeast(1).of(input).getValue(0);
	        		will(returnValue(10.5));
	        		atLeast(1).of(input).getValue(1);
	        		will(returnValue(-5.3));
	        		atLeast(1).of(input).getValue(2);
	        		will(returnValue(7.99));
	        		
	    		}
	    	});
	    	
	    	final KeyedValues output = mockingContext2.mock(KeyedValues.class);
	    	mockingContext2.checking(new Expectations(){
	    		{
	        		atLeast(1).of(output).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(output).getKey(0);
	        		will(returnValue(1.0));
	        		atLeast(1).of(output).getKey(1);
	        		will(returnValue(1.1));
	        		atLeast(1).of(output).getKey(2);
	        		will(returnValue(1.2));
	        		
	        		atLeast(1).of(output).getValue(0);
	        		will(returnValue(10.5/(10.5-5.3+7.99)));
	        		atLeast(1).of(output).getValue(1);
	        		will(returnValue((10.5-5.3)/(10.5-5.3+7.99)));
	        		atLeast(1).of(output).getValue(2);
	        		will(returnValue((10.5-5.3+7.99)/(10.5-5.3+7.99)));
	        		
	    		}
	    	});
	    	assertEquals("testing with mixed values", true, DataUtilities.getCumulativePercentages(input).equals(output));
	    }
	    
	    //A test use keys with String type to see if method can work correctly
	    @Test
	    public void TestStringKeyForMethodGetCumulativePercentages() {
	    	final KeyedValues input = mockingContext.mock(KeyedValues.class);
	    	mockingContext.checking(new Expectations(){
	    		{
	        		atLeast(1).of(input).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(input).getKey(0);
	        		will(returnValue("one"));
	        		atLeast(1).of(input).getKey(1);
	        		will(returnValue("two"));
	        		atLeast(1).of(input).getKey(2);
	        		will(returnValue("three"));
	        		
	        		atLeast(1).of(input).getValue(0);
	        		will(returnValue(10.5));
	        		atLeast(1).of(input).getValue(1);
	        		will(returnValue(-5.3));
	        		atLeast(1).of(input).getValue(2);
	        		will(returnValue(7.99));
	        		
	    		}
	    	});
	    	
	    	final KeyedValues output = mockingContext2.mock(KeyedValues.class);
	    	mockingContext2.checking(new Expectations(){
	    		{
	        		atLeast(1).of(output).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(output).getKey(0);
	        		will(returnValue("one"));
	        		atLeast(1).of(output).getKey(1);
	        		will(returnValue("two"));
	        		atLeast(1).of(output).getKey(2);
	        		will(returnValue("three"));
	        		
	        		atLeast(1).of(output).getValue(0);
	        		will(returnValue(10.5/(10.5-5.3+7.99)));
	        		atLeast(1).of(output).getValue(1);
	        		will(returnValue((10.5-5.3)/(10.5-5.3+7.99)));
	        		atLeast(1).of(output).getValue(2);
	        		will(returnValue((10.5-5.3+7.99)/(10.5-5.3+7.99)));
	        		
	    		}
	    	});
	    	assertEquals("testing with string key", true, DataUtilities.getCumulativePercentages(input).equals(output));
	    }
	    
	    //A test use KeyedValues object with null value to see if method can work correctly
	    @Test
	    public void TestNullValueGetCumulativePercentages() {
	    	final KeyedValues input = mockingContext.mock(KeyedValues.class);
	    	mockingContext.checking(new Expectations(){
	    		{
	        		atLeast(1).of(input).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(input).getKey(0);
	        		will(returnValue(1.0));
	        		atLeast(1).of(input).getKey(1);
	        		will(returnValue(1.1));
	        		atLeast(1).of(input).getKey(2);
	        		will(returnValue(1.2));
	        		
	        		atLeast(1).of(input).getValue(0);
	        		will(returnValue(null));
	        		atLeast(1).of(input).getValue(1);
	        		will(returnValue(null));
	        		atLeast(1).of(input).getValue(2);
	        		will(returnValue(null));
	        		
	    		}
	    	});
	    	
	    	final KeyedValues output = mockingContext2.mock(KeyedValues.class);
	    	mockingContext2.checking(new Expectations(){
	    		{
	        		atLeast(1).of(output).getItemCount();
	        		will(returnValue(3));
	        		
	        		atLeast(1).of(output).getKey(0);
	        		will(returnValue(1.0));
	        		atLeast(1).of(output).getKey(1);
	        		will(returnValue(1.1));
	        		atLeast(1).of(output).getKey(2);
	        		will(returnValue(1.2));
	        		
	        		atLeast(1).of(output).getValue(0);
	        		will(returnValue(null));
	        		atLeast(1).of(output).getValue(1);
	        		will(returnValue(null));
	        		atLeast(1).of(output).getValue(2);
	        		will(returnValue(null));
	        		
	    		}
	    	});
	    	assertEquals("testing null value", true, DataUtilities.getCumulativePercentages(input).equals(output));
	    }
	    
	  //A test to see if passing a null object as an argument will be accepted
	    @Test
	    public void TestNullForMethodGetCumulativePercentages(){
	    	boolean flag = false;
	    	try {
	    		DataUtilities.getCumulativePercentages(null);
	    		flag = true;
	    	}catch(Exception e){
	    	}
	    	assertFalse("Test with null argument",flag);
	    }

	    @After
	    public void tearDown() throws Exception {
	    }

	}
}
