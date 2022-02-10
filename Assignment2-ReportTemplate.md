**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

# 1 Introduction

In this lab, our goal was to test the 5 methods in the Range class and 5 methods in the Data Utilities class. It is a black box testing for both classes since we don’t know the actual code implementation. In order to perform a comprehensive testing for these methods, we followed the equivalence class technique and boundary value analysis technique. The test method we chose for the Range class is Equals, toString, Contains, GetLengthTesting and GetLowerBoundTest.The ones we chose for DataUtilities class is GetCumulativePercentages, createNumberArray2D, createNumberArray, calculateColumnTotal and calculateRowTotal. 

# 2 Detailed description of unit test strategy
In this lab, We followed Equivalence class testing and Boundary testing for the 5 methods of the Range Class as well as for the Data Utilities Class.

Class:Range Method:Equals

For testing of the equals method, we used an equivalence class technique to divide input into different intervals, which are non Range object and Range object. And within the Range object, we divided it into input with equal, or different range compared to the target object. And we have boundary testing in which the input is divided into the same lower bound, same upper bound and very close values of upper and lower bound in the range object and then compares all these input Range objects with the target object.

Partion of Equivalence classes and Boundary testing is as follows.

1.testingSameRangeObject(): (Equivalent class with same range object) 
2.testingDifferentRangeObject():  (Equivalent class with different range)
3.testingStringObject(): (Equivalent class with different class object) 
4.testingSamelowerBoundOfRangeObject(): (Boundary test with same lower boundary of range object)
5.testingSameUpeerBoundRangeObject(): (Boundary test with same upper boundary of range object)
6.testingCloseRangeObject(): (Boundary test with very closer values to lower and upper bound respectively)

Class:Range Method:toString

To test the toString method, an equivalence class method is used to divide input into different classes, which is Integer Range (positive range, negative range), and decimal range. A boundary test is used to test for range lower bound equals upper bound. And when an uninitialized object is passed as an input. The passing criteria is based on using an assertEqual method to see if actual output String matches with the expected String for test method 1,2,3,4. For test method 5, we use an assertTrue function to see if there is an exception thrown out with a null input.

Partion of Equivalence classes and Boundary testing is as follows.

1.testPositiveForMethodToString(): (Equivalence class for all Range input with positive bounds)
2.testNegativeForMethodToString(): (Equivalence class for all Range input with negative bounds)
3.testTwoDecimalForMethodToString(): (Equivalence class for all Range input with decimal bounds)
4.testSameBoundForMethodToString(): (Boundary Test for all Range input with same bounds)
5.testNullForMethodToString(): (Equivalence class for uninitialized Range input) 



# 3 Test cases developed

All the test Methods that were developed for the methods for the Range class and Data Utilities Class are as follows.

Class:Range  Method:Equals 

1.testingSameRangeObject(): Passed JUnit test
2.testingDifferentRangeObject(): Passed JUnit test
3.testingStringObject(): Passed JUnit test
4.testingSamelowerBoundOfRangeObject(): Passed JUnit test
5.testingSameUpeerBoundRangeObject(): Passed JUnit test
6.testingCloseRangeObject(): Not Passed JUnit test

Reference: 

public boolean equals(java.lang.Object obj): Tests this object for equality with an arbitrary object.
Overrides: equals in class java.lang.Object
Parameters: obj - the object to test against (null permitted).
Returns: true if the input object is an equivalent range.

Class:Range Method:toString

1.testPositiveForMethodToString(): Passed JUnit test
2.testNegativeForMethodToString(): Passed JUnit test
3.testTwoDecimalForMethodToString(): Passed JUnit test
4.testSameBoundForMethodToString(): Passed JUnit test
5.testNullForMethodToString(): Passed JUnit test

Reference:
public java.lang.String toString(): Returns a string representation of this Range.
Overrides: toString in class java.lang.Object
Returns: A String "Range[lower,upper]" where lower=lower range and upper=upper range.

Class:Range Method:Contains


# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
