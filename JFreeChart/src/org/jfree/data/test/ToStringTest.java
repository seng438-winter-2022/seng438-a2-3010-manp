package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

//to test ToString method within Range class
public class ToStringTest {
	private Range test1;
	private Range test2;
	private Range test3;
	private Range test4;
	private Range test5;
    // Different ranges are created for testing purpose
    @Before
    public void setUp() throws Exception {
    	test1 = new Range (10,30);
    	test2 = new Range (-30, -10);
    	test3 = new Range (10.55, 99.55);
    	test4 = new Range (0,0);
    }
    // Checking to see if correct positive values that are in range are returned from toString() method	
    @Test
    public void testPositiveForMethodToString() {
    	assertEquals("Range with lower 10 and upper 100, by calling toString method",
    			"Range[10.0,30.0]", test1.toString());
    }
    // Checking to see if correct negative values that are in range are returned from toString() method	
    @Test
    public void testNegativeForMethodToString() {
    	assertEquals("Range with lower -100 and upper -10, by calling toString method",
    			"Range[-30.0,-10.0]", test2.toString());
    }
     // Checking to see if correct decimal values that are in range are returned from toString() method	
    @Test
    public void testTwoDecimalForMethodToString() {
    	assertEquals("Range with lower 10.5 and upper 99.5, by calling toString method",
    			"Range[10.55,99.55]", test3.toString());
    }
    // Checking to see if correct values that are in range are returned from toString() method	
    @Test
    public void testSameBoundForMethodToString() {
    	assertEquals("Range with lower 0 and upper 0,by calling toString method",
    			"Range[0.0,0.0]", test4.toString());
    }
    // Checking to see if empty string is returned as intended.
    @Test
    public void testNullForMethodToString() {
    	boolean flag = false;
    	try {
    		test5.toString();
    	}catch(Exception e) {
    		flag = true;
    	}
    	assertTrue("Test with uninitialized input",flag);
    }
    
    @After
    public void tearDown() throws Exception {
    	test1 = null;
    	test2 = null;
    	test3 = null;
    }
    
}
