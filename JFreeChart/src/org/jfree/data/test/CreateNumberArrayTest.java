package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * Reference:
 * public static java.lang.Number[] createNumberArray(double[] data): Constructs an array of Number objects from an array of double primitives.
 * Parameters: data - An array of double primitives (null not permitted).
 * Returns: An array of Number objects.
 * Throws: InvalidParameterException - if invalid data object is passed in.
 */

/*
 * Testing Method NumberArrayTest in the Data Utilities Class 
 */

public class CreateNumberArrayTest extends DataUtilities {
	
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
