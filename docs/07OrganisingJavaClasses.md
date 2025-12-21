## Chapter 7: Organising Java Classes

### The Aims

In this lab you will reorganize your existing classes from previous labs into a proper package structure using IntelliJ IDEA. You will learn how to create packages, move classes between packages, and understand how package declarations affect your code.

### Understanding Your Current Structure

By now, you should have several classes from previous exercises, including classes like:
- `MyFirstClass` (from Chapter 1)
- `Account` and its subclasses `SavingsAccount` and `CurrentAccount` (from Chapters 4 and 6)
- `TestAccount`, `TestInheritance` or similar test classes


Currently, all these classes are likely in the default package (no package declaration). We're going to organize them into a logical package structure.

### Creating Your Package Structure

1. In IntelliJ, in the Project view, locate your `src` folder (or `src/main/java` if using Maven/Gradle).

2. Right-click on the `src` folder and select New → Package.

3. In the dialog, enter `com.banking.model` as the package name and click OK. This will be for your banking domain classes.

4. Create another package called `com.banking.test` for your test classes.


Your package structure should now look like this:
```
src/
  com/
    banking/
      model/
      test/
```

### Moving Classes into Packages

Now you'll move your existing classes into the appropriate packages.

#### Moving the Account Classes

1. In the Project view, find your `Account` class.

2. Click and drag the `Account` class onto the `com.banking.model` package. IntelliJ will prompt you to confirm the move.

3. Click "Refactor" in the dialog. IntelliJ will automatically:
   - Add the package declaration to the class
   - Update all references to this class throughout your project
   - Move the file to the correct folder structure

4. Repeat this process for `SavingsAccount` and `CurrentAccount`, moving them to `com.banking.model`.

#### Moving Test Classes

1. Find your test class (e.g., `TestAccount`).

2. Drag that to the `com.banking.test` package and click "Refactor".


### Examining the Changes

1. Open your `Account` class. Notice that IntelliJ has added a package declaration at the top:
```java
package com.banking.model;

public class Account {
    // ...existing code...
}
```

2. Open one of your test classes. Notice that IntelliJ has added import statements for the classes it uses:
```java
package com.banking.test;

import com.banking.model.Account;
import com.banking.model.SavingsAccount;

public class TestAccount {
    // ...existing code...
}
```

### Understanding Package Access

1. In your `Account` class, try changing the access modifier of one of your methods from `public` to package-private (no modifier):
```java
void someMethod() {  // package-private - no access modifier
    // ...
}
```

2. Try to access this method from your test class in `com.banking.test`. What happens? You should get a compilation error because the method is only accessible within the same package.

3. Change it back to `public` to fix the error.

### Creating a New Class in a Package

1. Right-click on the `com.banking.model` package.

2. Select New → Java Class.

3. Name it `Customer` and click OK.

4. Notice that IntelliJ automatically adds the correct package declaration:
```java
package com.banking.model;

public class Customer {
    
}
```

5. Add some simple properties to the Customer class, such as:
```java
package com.banking.model;

public class Customer {
    private String name;
    private String customerId;
    
    // Add getters and setters using Alt+Insert → Getter and Setter
}
```

### Optional: Running from Command Line

If you want to see how packages work at the command line level:

1. Open a terminal in IntelliJ (View → Tool Windows → Terminal).

2. Navigate to your `src` folder.

3. Compile a class manually:
```bash
javac com/banking/model/Account.java
```

4. Try to run a test class from the src directory:
```bash
java com.banking.test.TestAccount
```

Notice how you must use the fully qualified name (including package) to run the class.

