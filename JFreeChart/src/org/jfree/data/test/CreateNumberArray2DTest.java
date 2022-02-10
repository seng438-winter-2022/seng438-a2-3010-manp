package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;

/*
 * public static java.lang.Number[][] createNumberArray2D(double[][] data):
 * Constructs an array of arrays of Number objects from a corresponding structure containing double primitives.
 * Parameters: data - An array of double primitives (null not permitted).
 * Returns: An array of Number objects.
 * Throws: InvalidParameterException - if invalid data object is passed in.
 */

/*
 * To test the Method CreateNumberArray2D in the Data Utilities Class 
  */
public class CreateNumberArray2DTest {

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
