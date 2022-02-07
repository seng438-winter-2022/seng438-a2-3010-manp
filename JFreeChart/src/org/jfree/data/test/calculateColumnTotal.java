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

public class calculateColumnTotal {
	Mockery context;
	
    @Before
    public void setUp() throws Exception {
    	context = new Mockery();
    }
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    @Test
    public void passingNullAsParameter() {
    	thrown.expect(InvalidParameterException.class);
    	DataUtilities.calculateColumnTotal(null, 0);
    }
	
	@Test
	public void positiveColumnValues() {
		final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(4));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.500001));
	            one(values).getValue(2, 0);
	            will(returnValue(0.05));
	            one(values).getValue(3, 0);
	            will(returnValue(10.00));
	            one(values).getValue(1, 1);
	            will(returnValue(100.00));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	   assertEquals("Adding 4 rows with positive values", result, 20.050001, .000000001d);
	}
	
	@Test
	public void negativeColumnValues() {
		final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(4));
	            one(values).getValue(0, 0);
	            will(returnValue(-5.000005));
	            one(values).getValue(1, 0);
	            will(returnValue(-15.5));
	            one(values).getValue(2, 0);
	            will(returnValue(-0.01));
	            one(values).getValue(3, 0);
	            will(returnValue(-10.00));
	            one(values).getValue(1, 1);
	            will(returnValue(-90.50));
	        }
	    });
	    
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	   assertEquals("Adding 4 rows with negative values", result, -30.510005, .000000001d);
	}
	
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
	
    @After
    public void tearDown() throws Exception {
    }

}
