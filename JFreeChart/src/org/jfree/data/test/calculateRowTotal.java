package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

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
 * Testing Method CalculateRowTtoal in the Data Utilities Class 
*/

public class calculateRowTotal {
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
	public void positiveRowValues() {
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
	
    @After
    public void tearDown() throws Exception {
    	context = null;
    }

}
