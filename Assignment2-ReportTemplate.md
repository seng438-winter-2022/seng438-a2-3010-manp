**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 23   |     |
| -------------- | --- |
| Tianfan Zhou   |     |
| Manpreet Singh |     |
|Muhammad Shakeel|     |
|Girimer Singh   |     |

# 1 Introduction

In this lab, our goal was to test the 5 methods in the Range class and 5 methods in the Data Utilities class. It is a black box testing for both classes since we don’t know the actual code implementation. In order to perform a comprehensive testing for these methods, we followed the equivalence class technique and boundary value analysis technique. The test method we chose for the Range class is Equals, toString, Contains, GetLength and GetLowerBound.The ones we chose for DataUtilities class is GetCumulativePercentages, createNumberArray2D, createNumberArray, calculateColumnTotal and calculateRowTotal. 

# 2 Detailed description of unit test strategy
In this lab, We followed Equivalence class testing and Boundary testing for the 5 methods of the Range Class as well as for the Data Utilities Class.

The detailed description of each method of Range and Data Utilities class is discribed as follows:

<Class:Range, Method:Equals>
For testing of the equals method, we used an equivalence class technique to divide input into different intervals, which are non Range object and Range object. And within the Range object, we divided it into input with equal, or different range compared to the target object. And we have boundary testing in which the input is divided into the same lower bound, same upper bound and very close values of upper and lower bound in the range object and then compares all these input Range objects with the target object.

<Class:Range, Method:toString>
To test the toString method, an equivalence class method is used to divide input into different classes, which is Integer Range (positive range, negative range), and decimal range. A boundary test is used to test for range lower bound equals upper bound. And when an uninitialized object is passed as an input. The passing criteria is based on using an assertEqual method to see if actual output String matches with the expected String for test method 1,2,3,4. For test method 5, we use an assertTrue function to see if there is an exception thrown out with a null input.

<Class:Range, Method:Contains>
To test this method, equivalence class testing and boundary testing was used. Using Equivalence class, the inputs were divided into value in range, value outside of lower and upper range. The boundary testing was performed with inputs as the same lower bound of range value value, same upper bound value, close value to upper bound and close value to the lower bound of range. The assertEquals was used to test the passing criteria based on whether the input value lies within the range object or outside the range.

<Class:Range, Method:GetLength>
In order to test the GetLength method in the range class, We used equivalence class technique and divided the input into different range objects and those were positive range object, negative range object, range object with same upper and lower value, range object with large upper and large negative lower value and finally range object with smaller difference between upper and lower value . Using these different range objects, the expected length value was compared with their respective range object using assertEquals test passing criteria.

<Class:Range, Method:GetLowerBound>
In order to test the GetLowerBound method in the range class, We used boundary testing technique to test lower bounds of the Range objects with the equivalent targeted object.
The different inputs that were tested in this testing were positive limits range object, negative limits range object and range object with very large decimal lower limit. The expected lower limit was compared with their respective actual output obtained from the input range object using assertEquals test passing criteria.

<Class:DataUtilities, Method:getCumulativePercentages>
To test GetCumulativePercentages method, an equivalence class technology is used to divide input into different classes: KeyedValues object with negative keys and values, KeyedValues object with positive keys and values, KeyedValues object with decimal keys and values, KeyedValues object with string keys and values, KeyedValues object with keys and null values. Also, a boundary analysis is used to test an input with an uninitialized object and null object. A mock object is used to replace the actual KeyedValues object in this testing. For the pass/fail criteria, we define a test case passed if the actual object equals the expected object we made (for methods 2,3,4). And for method 1, if the method throws out an exception as expected.

<Class:DataUtilities, Method:createNumberArray2D>
The testing of the CreateNumber2DArray method was performed using the equivalence class technique. Using this technique, the input was divided into a null, empty double 2d array, a 2D double array with positive values and a 2D double array with negative values. The test was performed and the expected Number 2D array was compared with the returned Number 2D array from this method using assertArrayEquals test passing criteria.

<Class:DataUtilities, Method:createNumberArray>
Method was tested by dividing input into four equivalent classes. Through each equivalent class, values tested are positive, negative, empty array and null input. All the outputs were compared to the equivalent expected Number array using assertArrayEquals test passing criteria.

<Class:DataUtilities, Method:calculateColumnTotal>
To test the method, inputs were divided into four equivalence classes, one for valid positive and negative values, one for null input, one for null values in the entire column and one for the invalid inputs. To check the boundary condition, a test was performed with the largest 32 bit signed int value and adding another number to check for overflow. All these Equivalence classes and boundary cases were tested based on assertEquals testing passing criteria.

<Class:DataUtilities, Method:calculateRowTotal>
Testing for this method was done using equivalence classes and boundary conditions. Input was divided based on valid positive and negative values, null input, null values in the entire column and invalid inputs passed as a parameter. To check the boundary condition 32 bit signed int value was passed as input along with more numbers to add. All these Equivalence classes and boundary cases were tested based on assertEquals testing passing criteria.


# 3 Test cases developed

All the test Methods that were developed with respect to their equivalence class for the methods of the Range class and Data Utilities Class are as follows.

# <Class:Range, Method:Equals>

1.testingSameRangeObject(): (Equivalent class with same range object)

2.testingDifferentRangeObject():  (Equivalent class with different range)

3.testingStringObject(): (Equivalent class with different class object) 

4.testingSamelowerBoundOfRangeObject(): (Boundary test with same lower boundary of range object)

5.testingSameUpeerBoundRangeObject(): (Boundary test with same upper boundary of range object)

6.testingCloseRangeObject(): (Boundary test with very closer values to lower and upper bound respectively)


# Result

Passed test: 1, 2, 3, 4, 5

Unpassed test: 6


# Reference 

public boolean equals(java.lang.Object obj): Tests this object for equality with an arbitrary object.

Overrides: equals in class java.lang.Object

Parameters: obj - the object to test against (null permitted).

Returns: true if the input object is an equivalent range.



# <Class:Range, Method:toString>

1.testPositiveForMethodToString(): (Equivalence class for all Range input with positive bounds)

2.testNegativeForMethodToString(): (Equivalence class for all Range input with negative bounds)

3.testTwoDecimalForMethodToString(): (Equivalence class for all Range input with decimal bounds)

4.testSameBoundForMethodToString(): (Boundary Test for all Range input with same bounds)

5.testNullForMethodToString(): (Equivalence class for uninitialized Range input) 


# # Result

Passed test: 1, 2, 3, 4, 5

Unpassed test: N/A


# Reference
public java.lang.String toString(): Returns a string representation of this Range.

Overrides: toString in class java.lang.Object

Returns: A String "Range[lower,upper]" where lower=lower range and upper=upper range.


# <Class:Range, Method:Contains>
1.testValueInRangeForMethodContains(): (Equivalence class with value lies in range)

2.testValueLessThanLowerBoundForMethodContains(): (Equivalence class with value lies outside the lower limit of range)

3.testValueMoreThanUpperBoundForMethodContains(): (Equivalence class with value lies outside the upper limit of range)

4.testLowerBoundRangeValueForMethodContains(): (Equivalence class with value equal to lower limit of range)

5.testUpperBoundRangeValueForMethodContains(): (Equivalence class with value equal to upper limit of range)

6.testLowerBoundRangeValueWithCloserValueForMethodContains(): (Equivalence class with value closer to lower limit of range)

7.testUpperBoundRangeValueWithCloserValueForMethodContains(): (Equivalence class with value closer to upper limit of range)


# Result

Passed test: 1, 2, 3, 4, 5

Unpassed test: 6, 7


# Reference
public boolean contains(double value): Returns true if the specified value is within the range and false otherwise.

Parameters: value - the value to be tested

Returns: true if the range contains the specified value.


# <Class:Range, Method:GetLength>

1.testDifferentUpperAndLowerBoundsForMethodGetLength(): (Equivalence class with different limits)

2.testSameUpperAndLowerBoundsForMethodGetLength(): (Equivalence class with same limits)

3.testNegativeUpperAndLowerBoundsForMethodGetLength(): (Equivalence class with different negative limits)

4.testLargeRangeForMethodGetLength(): (Equivalence class with large negative lower limit and large positive upper limits)

5.testSmallRangeForMethodGetLength(): : (Equivalence class with small difference between upper and lower limit)


# Result

Passed test: 1, 2, 3, 4, 5

Unpassed test: N/A


# Reference
public double getLength()

Returns the length of the range.

Returns:The length.



# <Class:Range, Method:GetLowerBound>

1.testLowerBoundPositiveValueForMethodGetLowerBound(): (Boundary testing with positive lower bound vale)

2.testLowerBoundNegativeValueForMethodGetLowerBound(): (Boundary testing with negative lower bound vale)

3.testLongDecimalLowerBoundValueForMethodGetLowerBound(): (Boundary testing with very large decimal lower bound value)


# Result

Passed test: 1, 2, 3

Unpassed test: N/A


# Reference

public double getLowerBound()

Returns the lower bound for the range.

Returns:The lower bound.


# <Class:DataUtilities, Method:getCumulativePercentages>

1.TestExceptionForMethodGetCumulativePercentages(): (Boundary condition with a null input)

2.TestPositiveForMethodGetCumulativePercentages(): (Equivalent class with positive keys and values)

3.TestNegativeForMethodGetCumulativePercentages(): (Equivalent class with negative keys and values)

4.TestMixForMethodGetCumulativePercentages(): (Equivalent class with decimal keys and values)

5.TestStringKeyForMethodGetCumulativePercentages(): (Equivalent class with string keys and values)

6.TestNullValueGetCumulativePercentages(): (Equivalent class with keys and null values)

7.TestNullForMethodGetCumulativePercentages (Boundary condition with a null input)


# Result:-

Passed test: 1, 4,5,7

Unpassed test: 2,3,6


# Reference:-

public static KeyedValues getCumulativePercentages(KeyedValues data): Returns a KeyedValues instance that contains the cumulative percentage values for the data in another 

KeyedValues instance. The cumulative percentage is each value's cumulative sum's portion of the sum of all the values. 

Parameters: data - the data (null not permitted).

Returns: The cumulative percentages.

Throws: InvalidParameterException - if invalid data object is passed in.



# <Class:DataUtilities, Method:createNumberArray2D>
1.TestNullForMethodCreateNumberArray2D(): (Equivalence class with null parameter)

2.TestEmptyDoubleArrayForMethodCreateNumberArray2D(): (Equivalence class with an empty array)

3.TestDoubleArrayForMethodCreateNumberArray2D(): (Equivalence class with a 2D array with positive values)

4.TestNegativeDoubleArrayForMethodCreateNumberArray2D(): (Equivalence class with a 2D array with negative values)



# Result:-

Passed test: 1, 2, 3, 4

Unpassed test: N/A


# Reference:-

public static java.lang.Number[][] createNumberArray2D(double[][] data)

Constructs an array of arrays of Number objects from a corresponding structure containing double primitives.

Parameters: data - An array of double primitives (null not permitted).

Returns: An array of Number objects.

Throws: InvalidParameterException - if invalid data object is passed in.


# <Class:DataUtilities, Method:createNumberArray>

1.passingNullAsParameter(): (Equivalence class as passing null as parameter to check for InvalidParameterException)

2.CreatingNumberArrayFromEmptyArray(): (Equivalence class with an empty array)

3.CreatingNumberArrayPositiveValues(): (Equivalence class with a positive double array to create a Number array of positive values)

4.CreatingNumberArrayNegativeValues(): (Equivalence class with a negative double array to create a Number array of negative values)



# Result:-

Passed test: 1, 2, 3, 4

Unpassed test: N/A


# Reference:-

public static java.lang.Number[] createNumberArray(double[] data)

Constructs an array of Number objects from an array of double primitives.

Parameters:data - An array of double primitives (null not permitted).

Returns:An array of Number objects.

Throws:InvalidParameterException - if invalid data object is passed in.



# <Class:DataUtilities, Method:calculateColumnTotal>

1.passingNullAsParameter(): (Equivalence class to get invalidParameterException)

2.intBoundaryValues(): (Boundary test to test the large values)

3.positiveNegativeColumnValues(): (Equivalence class with mix of positive and negative values)

4.invalidFirstInputTest(): (Equivalence class with invalid input)

5.invalidSecondInputTest(): (Equivalence class with invalid input)

6.NullColumnValueTest(): (Equivalence class with null values in the column)


# Result:-

Passed test: 1, 2, 3, 4, 5, 6

Unpassed test: N/A


# Reference:-

public static double calculateColumnTotal(Values2D data, int column)

Returns the sum of the values in one column of the supplied data table. With invalid input, a total of zero will be returned.

Parameters: data - the table of values (null not permitted).
column - the column index (zero-based).

Returns: The sum of the values in the specified column.

Throws: InvalidParameterException - if invalid data object is passed in.



# <Class:DataUtilities, Method:calculateRowTotal>

1.passingNullAsParameter(): (Equivalence class to get invalidParameterException)

2.intBoundaryValues(): (Boundary test to test the large values)


3.positiveNegativeRowValues(): (Equivalence class with mix of positive and negative values)

4.invalidFirstInputTest(): (Equivalence class with invalid input)

5.invalidSecondInputTest(): : (Equivalence class with invalid input)

6.NullRowValueTest(): (Equivalence class with null values in the row)


# Result:-

Passed test: 1, 2, 3, 4, 5, 6

Unpassed test: N/A


# Reference:-

public static double calculateRowTotal(Values2D data, int row)

Returns the sum of the values in one row of the supplied data table. With invalid input, a total of zero will be returned.

Parameters: data - the table of values (null not permitted).
row - the row index (zero-based).

Returns: The total of the values in the specified row.

Throws: InvalidParameterException - if invalid data object is passed in.

# Benefits and drawbacks about using mocking
One of the benefits by using mocking is to isolate unit tests to avoid external dependencies. Mock classes are fake classes. For example, we can use mock objects to replace classes and methods, or perform file reading, database connection and sending emails actions. This is to say, if we are trying to test certain functionality of a method or a class, we need to make sure no other classes or functions run simultaneously with our test. Otherwise, we will have no idea if other classes have influenced our test results. A mock object can help to achieve this by dummy implementation for an interface or a class in the mock framework.

Also, mock has functionality of behavioral testing to trace how the result has been achieved by using API such as atLeast(count).of(mock) or between (min,max).of(mock). For example, we can trace how many times a certain method has been called within the test by using a mock object.

There are also some drawbacks when using mocks. Mocks returns the value that is decided by the tester, but the real value returned by the object may be different or unexpected. Mocks also need to be updated along with the application code that requires additional resources and test code maintenance. Although, mocking is a good approach to do the complex values testing, but mockery is not beneficial in white box testing. In white box testing, Using mockery, there are more chances to fail testing whey they shouldn't fail. 


# 4 How the team work/effort was divided and managed
As a group, we worked on setting up the required softwares (JUnit 4 and Eclipse) needed to complete this lab. Moreover, we were able to set up the github so that every member can upload their test cases. We decided to split the test cases among group members so that each member understands the concepts of equivalence class, boundary class, and mocking objects in unit test code. The test cases were split as follows: Muhammad Shakeel worked on testing the following methods Contains and Equals. Manpreet Singh worked on CreateNumberArray2D, GetLength and GetLowerBoundTest. Tianfan Zhou worked on GetCumulativePercentages, ToString. Grimer Singh worked on NumberArray, calculateColumnTotal and calculateRowTotal. We reviewed our test cases as a group so that all test cases were meeting the details that were outlined in the Javadoc and changes were made if necessary. 


# 5 Difficulties encountered, challenges overcome, and lessons learned
In this lab, we found it’s difficult to divide the input into different equivalence classes, and also find out all possible boundary conditions. We spent a lot of time thinking about how to divide input with equivalence classes to make a comprehensive test. And we learnt a lot from this process.

One other difficulty we encountered was that the hamcrest-library jar file was missing from the github. This was one of the files needed to have the setup process completed. This issue was resolved by finding this file from an online website. This process did waste some of our time and it caused frustration as we could have used this time to start writing test cases. Another issue we faced was understanding of mocking for jMock. We had to spend some amount of time reviewing our class notes so that we could use this technique to complete this lab. Once we gained a good understanding of the concept of mocking, we were able to follow the Javadocs specifications to create test cases according to the needs of each method.  This lab gave us a good understanding about how equivalence classes, boundary value analysis and mocking can be used for creating test cases. The boundary value analysis and equivalence classes are used to perform testing for methods with possible ranges/boundaries of inputs to see if the method is executing as it should. The object mocking was used to have a similar behavior as the object.


# 6 Comments/feedback on the lab itself
The lab document contained a lot of detailed information about the required setup needed (eclipse and junit 4). Moreover, the lab document outlined every step to get eclipse and junit 4 to work. This was helpful as we were able to use the RangeTest to confirm that we had the required jar files to start writing the test cases. Moreover, In this lab, we have applied our knowledge of equivalence class testing and boundary testing which learnt from lecture into practice. It is a meaningful lab in which we have spent time to figure out as many possibilities as we can, to divide possible input values into different equivalent classes in order to make a comprehensive testing. In our testing result, we have actually found some bugs in some of the boundary testing. From this lab, we learnt the importance of using equivalence class and boundary testing technologies for black box testing.

