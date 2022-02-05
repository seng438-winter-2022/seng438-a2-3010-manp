package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

//to test ToString method within Range class
public class ToStringTest {
	private Range test1;
	private Range test2;
	private Range test3;
	
    @Before
    public void setUp() throws Exception {
    	test1 = new Range (10,30);
    	test2 = new Range (-30, -10);
    	test3 = new Range (10.55, 99.55);
    }

    @Test
    public void testPositiveForMethodToString() {
    	assertEquals("Range with lower 10 and upper 100, by calling toString method",
    			"Range[10.0,30.0]", test1.toString());
    }
    
    @Test
    public void testNegativeForMethodToString() {
    	assertEquals("Range with lower -100 and upper -10, by calling toString method",
    			"Range[-30.0,-10.0]", test2.toString());
    }
    
    @Test
    public void testTwoDecimalForMethodToString() {
    	assertEquals("Range with lower 10.5 and upper 99.5, by calling toString method",
    			"Range[10.55,99.55]", test3.toString());
    }
    
    @After
    public void tearDown() throws Exception {
    	test1 = null;
    	test2 = null;
    	test3 = null;
    }
    
}
