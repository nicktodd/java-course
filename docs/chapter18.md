## Chapter 18 Working with JUnit
### Aims
In this exercise you will build some JUnit Test harnesses. You will build some basic tests.
### Building a Basic Test Harness
In the first test that you will be creating, you will be testing how the Java VM handles String objects.

You will be testing whether the following code examples return true or false. In fact, you might like to predict the answer before you start!

```String s1 = "hello";```
```String s2 = "hello";```
```String s3 = new String(“hello”);```

```boolean b1 = (s1 == s2);``
```boolean b2 = (s1 == s3)``;
```boolean b3 = (s1.equals(s3);```

Your predictions:
b1 is  _________________

b2 is  _________________

b3 is _________________


1.	In one of your Eclipse projects, right click on the src folder, click New, and then click Junit Test Case.
2.	In the dialog box that appears, set the class to be based on JUnit 4, and then set the name of the class to be TestStrings.
3.	Add three empty methods called testStringPool, testNewString, and testEquals. In each case, the return type is void, and there are no arguments. Annotate them using @Test.
4.	Implement each method in turn, declaring the Strings locally. This means that they will be declared more than once, but you will address that later. The assertXXX method that you will use in each case is assertTrue. An example is shown here:
assertTrue(s1==s2);
5.	You will need to add a static import for the assert methods. Eclipse will prompt you for those.
### Running your Test
1.	Run your test by right clicking in the code, click Run As, and then click JUnit Test.
2.	The Eclipse test runner will appear with your test results.
3.	Check the results against your predictions, do they match?

### Adding Fixtures to your Test
1.	In your current test, you have the String variables declared locally. You will now edit the test class to incorporate fixtures.
2.	Add three instance variables to represent your three Strings, s1, s2, and s3.
3.	Add a setUp() method annotated with @Setup and within it initialize the three Strings. Remember to use the new operator for s3. Initialize them all with the text “hello”.
4.	Modify your three test methods to use the instance variables in place of the local variables. 
5.	Run your tests as before.
 Adding Fixtures to your Test
1.	In your current test, you have the String variables declared locally. You will now edit the test class to incorporate fixtures.
2.	Add three instance variables to represent your three Strings, s1, s2, and s3.
3.	Add a setUp() method annotated with @Setup and within it initialize the three Strings. Remember to use the new operator for s3. Initialize them all with the text “hello”.
4.	Modify your three test methods to use the instance variables in place of the local variables. 
5.	Run your tests as before.
 


 
