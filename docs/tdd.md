# Chapter 18 Working with JUnit and Test Driven Development

## Aims

In the old days when people wanted to know the time they would ring a phone number and the automated system at the other end would tell them the time. This was called the speaking clock. It is still available today, although I am not sure how busy it is! You can find out about it here:

https://en.wikipedia.org/wiki/Speaking_clock

In this exercise you practice doing some Test Driven Development for a simple Java Class that has a function that returns the time as a string if you give it a LocalTime object. It would be the part of a speaking clock that works out what to say for a given time.


You will be applying TDD practices when you create this example. The exercise assumes that you will be using JUnit 5, but you could complete this exercise using any test framework you like. 

## Building a Basic Test Harness

1. Using your preferred IDE, create a new Maven project. The artifact ID and group ID can be whatever you like. 

2. Add the following dependency to your project:

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.7.2</version>
    <scope>test</scope>
</dependency>
```
3. Now since we are doing TDD, the first class you will create is a test class. So in your project expand `src/test/java`, and create a test class for your text to speech test. What will you call this class? This is a very important question. You might be tempted to call it `SpeakingClockTest` but you are not creating anything that speaks, and it is not a clock either! So not a good name. How about `TimeToTextConverterTest`? It is up to you. But you need to think about your naming carefully.

4. Now add a method to your test class. What time will you test for first? What is an easy time to test for? Maybe midnight or midday might be a good choice. So add a test method something ilke this. Again think carefully about the name.

```
@Test
public void canDoMidnight() {


}
```

5. Within the method you will now write the code that will use your (non existant) class under test to get the text value from a LocalTime. The code could look something like this:

```
TimeToTextConverter timeToTextConverter = new TimeToTextConverter(); // this will error as you haven't written the class yet!
String timeAsText = timeToTextConverter.convertTimeToText(LocalTime.MIDNIGHT); // this method doesn't exist either!
assertEquals("midnight", timeAsText);
```

Notice here we have to come up with names for our class and method. The code above uses the name TimeToTextConverter and convertTimeToText. You could use different names. The main thing is, you are coming up with names within the context of using the class.

6. Now create the actual class under test, so in your IDE project explorer, locate the src/main/java folder and create the class under test (in our case TimeToTextConverter). Add in the method called convertTimeToText or whatever you called it, and return null for now. So you could end up with a class something like this:

```
public class TimeToTextConverter {

    public String convertTimeToText(LocalTime time) {
        return null;
    }

}
```

Once you have created this class, your code should now all compile. So you are no longer in the phase where stuff doesn't compile, but if you run the test it will not pass. 

7. Run your unit test. It should fail. You are in the red phase. Now let's get it to green.

8. We could fake it for now, so return to your implementation class, and return the String "midnight".

```
public class TimeToTextConverter {

    public String convertTimeToText(LocalTime time) {
        return "midnight";
    }

}
```
9. Run your test again. This time it should pass. It should be 'green'.

10. Now we enter the final 'refactor' phase which means we will improve the implementation. Clearly at the moment it is faking it. So return to your implementation class, and refine the function so it checks the hour and minute and only returns midnight if the hour is 0 and the minutes are midnight. Otherwise it must returns null. A simple if / else will suffice.

```
public String convertTimeToText(LocalTime time) {
    if (time.getHour() == 0 && time.getMinute() == 0) {
        return "midnight";
    }
    else {
        return null;
    }
}
```

11. Rerun the test. It should still be green, but this time, it is actually looking at the time! 

12. Now we have been around one cycle of TDD (red/green/refactor). So now repeat the process for Midday. So you will add another test, then modify the implementation method to work with midday as well as midnight. 

You can then keep going around the Red/Green/Refactor so your TextToSpeechConverter can handle the following:

* On the hour
* Half past the hour
* Quarter past / Quarter to the hour
* Five minutes past
* Ten minutes past
* Just after (any of the above)
* Almost (any of the above)

Each time you add a test, refactor the method that works so it can also handle your new test. Don't forget to refactor as you go to improve the quality of your class under test, and the tests themselves. For example, it might make sense to use a fixture to deal with the TextToSpeechConverter since every single test will need one. If you do that, it would look something like this:

```
private TimeToTextConverter timeToTextConverter;

@BeforeEach
public void setup() {
    timeToTextConverter = new TimeToTextConverter();
}
```
