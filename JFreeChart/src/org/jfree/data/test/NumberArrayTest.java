package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NumberArrayTest extends DataUtilities {
	
	final double[] input = {10.005, 20.0, 30.095};
	final double[] input2 = {-10.005, -20.0, -30.095};
	final double[] input3 = {+10.005, +20.0, -30.005};
	
	final Number[] result = {10.005, 20.0, 30.095};
	final Number[] result2 = {-10.005, -20.0, -30.095};
	final Number[] result3 = {+10.005, +20.0, -30.005};
	
	@Before
	public void setup() {

	}
	
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    @Test
    public void passingNullAsParameter() {
    	thrown.expect(InvalidParameterException.class);
    	DataUtilities.createNumberArray(null);
    }
	
    @Test
    public void CreatingNumberArrayPositiveValues() {
 	   assertArrayEquals("Number array do not correspond to double array",result, DataUtilities.createNumberArray(input));
    }

    @Test
    public void CreatingNumberArrayNegativeValues() {
 	   assertArrayEquals("Number array do not correspond to double array",result2, DataUtilities.createNumberArray(input2));
    }

    @Test
    public void CreatingNumberArrayMixValues() {
 	   assertArrayEquals("Number array do not correspond to double array",result3, DataUtilities.createNumberArray(input3));
    }

}
