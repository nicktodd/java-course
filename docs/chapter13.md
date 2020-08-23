## Chapter 13: Lambda Expressions

### Aims

This short exercise will be your first use of the Lambda expressions. You will then revisit using them throughout various other chapters in the course.

### Creating a Lambda

1.	Within the same project as your interfaces example from before, create a new class called TestLambdas and add into it a main method.
2.	In the main method, declare a new Detailable reference and assign it to a lambda expression that returns  “hello world”.

```
Detailable det = () -> { return “hello world”;};
```

3.	Now invoke the getDetails method on the lambda and print the response.

```
System.out.println(det.getDetails());
```

 
