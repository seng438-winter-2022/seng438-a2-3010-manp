package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.jmock.Expectations;

/*
 * public static double calculateRowTotal(Values2D data,int row):
 * Returns the sum of the values in one row of the supplied data table. With invalid input, a total of zero will be returned.
 * Parameters: data - the table of values (null not permitted).
 *             row - the row index (zero-based).
 * Returns: The total of the values in the specified row.
 * Throws: InvalidParameterException - if invalid data object is passed in.
 */

/*
 * Testing Method CalculateRowTtoal in the Data Utilities Class 
*/

public class CalculateRowTotalTest {
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
