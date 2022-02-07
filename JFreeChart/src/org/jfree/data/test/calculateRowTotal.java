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

public class calculateRowTotal {
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
    	DataUtilities.calculateRowTotal(null, 0);
    }
	
	@Test
	public void positiveRowValues() {
		final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(4));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.500001));
	            one(values).getValue(0, 2);
	            will(returnValue(0.05));
	            one(values).getValue(0, 3);
	            will(returnValue(10.00));
	            one(values).getValue(1, 1);
	            will(returnValue(100.00));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 0);
	   assertEquals("Adding 4 rows with positive values",20.050001, result , .000000001d);
	}
	
	@Test
	public void negativeRowValues() {
		final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {
	        {
	        	one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(-5.000005));
	            one(values).getValue(0, 1);
	            will(returnValue(-15.5));
	            one(values).getValue(0, 2);
	            will(returnValue(-10.00));
	            one(values).getValue(1, 1);
	            will(returnValue(-90.50));
	        }
	    });
	    
	    double result = DataUtilities.calculateRowTotal(values, 0);
	   assertEquals("Adding 3 rows with negative values", -30.500005, result, .000000001d);
	}
	
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
    }

}
