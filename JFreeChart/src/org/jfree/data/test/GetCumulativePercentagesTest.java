package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

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
public class GetCumulativePercentagesTest {
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
