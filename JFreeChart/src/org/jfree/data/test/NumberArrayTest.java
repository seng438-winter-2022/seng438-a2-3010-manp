package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * Testing Method NumberArrayTest in the Data Utilities Class 
*/

public class NumberArrayTest extends DataUtilities {
	
	final double[] input = {10.005, -20.0, 30.095};
	final double[] input2 = {-10.005, -20.0, -30.095};
	final double[] input3 = {};
	
	final Number[] result = {10.005, -20.0, 30.095};
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

}
