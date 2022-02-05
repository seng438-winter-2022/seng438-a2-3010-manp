package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

//to test getCumulatvePercentages method within DataUtilities class

//public static KeyedValues getCumulativePercentages(KeyedValues data)
//Returns a KeyedValues instance that contains the cumulative percentage
//values for the data in another KeyedValues instance.
//The cumulative percentage is each value's cumulative sum's portion of the sum of all the values. 
public class GetCumulativePercentages {
	Mockery mockingContext;
	Mockery mockingContext2;
	
    @Before
    public void setUp() throws Exception {
    	mockingContext = new Mockery();
    	mockingContext2 = new Mockery();
    }


    @Test
    public void TestNullForMethodGetCumulativePercentages(){
    	boolean flag = false;
    	try {
    		DataUtilities.getCumulativePercentages(null);
    		fail("Null is not allowed as a parameter");
    	}catch(Exception e){
    		flag = true;
    	}
    	assertTrue("Test with null argument",flag);
    }
    
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
    
    

    @After
    public void tearDown() throws Exception {
    	System.out.println("Tear Down");
    }

}
