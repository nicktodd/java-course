## Chapter 18 Working with JUnit

### Aims

In this exercise you will build some JUnit 5 test harnesses. You will build some basic tests using modern JUnit Jupiter annotations and assertions.

### Setting up JUnit 5 in IntelliJ

Before starting, ensure your project has JUnit 5 (JUnit Jupiter) as a dependency:

1. If using Maven, add this to your `pom.xml`:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

2. If using Gradle, add this to your `build.gradle`:
```gradle
testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
```

3. If not using a build tool, IntelliJ will prompt you to add JUnit 5 to the classpath when you create your first test.

### Building a Basic Test Harness

In the first test that you will be creating, you will be testing how the Java VM handles String objects.

You will be testing whether the following code examples return true or false. In fact, you might like to predict the answer before you start!

```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");

boolean b1 = (s1 == s2);
boolean b2 = (s1 == s3);
boolean b3 = (s1.equals(s3));
```

Your predictions:
b1 is  _________________

b2 is  _________________

b3 is _________________


### Creating the Test Class

1. In your IntelliJ project, right-click on the `src/test/java` folder (or create it if it doesn't exist by right-clicking on your module and selecting New → Directory).

2. Select New → Java Class and name it `TestStrings`.

3. IntelliJ will create the class. Now you need to add the JUnit 5 imports. Add these at the top of your file:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
```

4. Add three empty test methods called `testStringPool()`, `testNewString()`, and `testEquals()`. Each method should:
   - Have a `void` return type
   - Take no arguments
   - Be annotated with `@Test` (from JUnit 5)

Your class should look like this:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStrings {
    
    @Test
    public void testStringPool() {
        // TODO
    }
    
    @Test
    public void testNewString() {
        // TODO
    }
    
    @Test
    public void testEquals() {
        // TODO
    }
}
```

5. Implement each method in turn, declaring the Strings locally. This means that they will be declared more than once, but you will address that later. The assert method that you will use in each case is `assertTrue()`. An example is shown here:
```java
@Test
public void testStringPool() {
    String s1 = "hello";
    String s2 = "hello";
    assertTrue(s1 == s2);
}
```

6. The static import for the assertion methods (`import static org.junit.jupiter.api.Assertions.*;`) allows you to use `assertTrue()`, `assertEquals()`, etc. without prefixing them with the class name. IntelliJ will help you add this import automatically when you use the assertions.

### Running your Test

1. Run your test by right-clicking on the test class in the editor or the Project view and selecting "Run 'TestStrings'". Alternatively, you can click the green play button that appears in the gutter next to the class name or individual test methods.

2. The IntelliJ test runner will appear in the Run tool window at the bottom of the screen showing your test results with a visual indicator (green for pass, red for fail).

3. Check the results against your predictions. Do they match?

### Adding Fixtures to your Test

In JUnit 5, fixtures are methods that run before or after each test. You'll use the `@BeforeEach` annotation to set up common test data.

1. In your current test, you have the String variables declared locally. You will now edit the test class to incorporate fixtures.

2. Add three instance variables to represent your three Strings: `s1`, `s2`, and `s3` at the class level.

3. Add a `setUp()` method annotated with `@BeforeEach` (note: this is different from JUnit 4's `@Before` annotation). Within it, initialize the three Strings. Remember to use the `new` operator for `s3`. Initialize them all with the text "hello".

Your code should look like this:
```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStrings {
    
    private String s1;
    private String s2;
    private String s3;
    
    @BeforeEach
    public void setUp() {
        s1 = "hello";
        s2 = "hello";
        s3 = new String("hello");
    }
    
    @Test
    public void testStringPool() {
        assertTrue(s1 == s2);
    }
    
    @Test
    public void testNewString() {
        assertFalse(s1 == s3);
    }
    
    @Test
    public void testEquals() {
        assertTrue(s1.equals(s3));
    }
}
```

4. Modify your three test methods to use the instance variables in place of the local variables. 

5. Run your tests as before by right-clicking and selecting "Run 'TestStrings'" or using the green play button.

### Understanding the Results

When you run the tests, you should see:
- `testStringPool()` passes because string literals are stored in the String pool, so `s1` and `s2` reference the same object
- `testNewString()` passes because `s3` is explicitly created with `new`, creating a separate object in heap memory
- `testEquals()` passes because the `equals()` method compares the content of the strings, not their references

### Additional JUnit 5 Features

JUnit 5 offers many improvements over JUnit 4:

1. **Better Assertions**: Use `assertEquals()` with a message for clearer test failures:
```java
@Test
public void testStringEquality() {
    assertEquals("hello", s1, "String should equal 'hello'");
}
```

2. **Display Names**: Make your test results more readable:
```java
@Test
@DisplayName("String literals should reference the same object in the String pool")
public void testStringPool() {
    assertTrue(s1 == s2);
}
```

3. **Grouped Assertions**: Test multiple conditions that should all be checked:
```java
@Test
public void testAllStringProperties() {
    assertAll(
        () -> assertTrue(s1 == s2, "Literals should be same object"),
        () -> assertFalse(s1 == s3, "New String should be different object"),
        () -> assertTrue(s1.equals(s3), "Content should be equal")
    );
}
```

Feel free to experiment with these additional features to make your tests more expressive and maintainable!

