## Appendix A: Java Networking with Sockets
### Aims
In this exercise, you will create a server and client application that will exchange information across a network. If you wish, you may work in pairs for this exercise, with one of you creating the client application, and one of you creating the server application.
### Part 1 Implementing the Server
To begin with, you will implement the server application. This application will read in lines of text from the client, and write it back to the client in upper case characters, so you a client can see that the server application has processed the data.

### Set up the required properties
1.	Create a new Java source file with a main method, and call the class MyServer and the file called MyServer.java.
2.	Within the main method declare an int called serverPort, and assign it the value 8081.
3.	Declare an int called clientPort that is not assigned.
4.	Declare a ServerSocket called serverSocket and set it to null.
5.	Declare a Socket called clientSocket and set it to null.
6.	Declare an InputStreamReader (isr), a BufferedReader (br) , and a PrintWriter (out), and assign them all to null.
### Create the ServerSocket
1.	Now add a try block, and within the try block, complete the following steps.
2.	Add a statement to print to the screen that you are waiting for a client application to connect.
3.	Instantiate your serverSocket using the appropriate port number as defined earlier. The code will block at this point until a client connects.
### Process a client request
1.	Accept the connection from the client, and assign the return value to your Socket reference.
2.	Obtain the client port number and display the value on the screen.
3.	Use the InputStreamReader to decorate the input stream from the client.
4.	Use the buffered stream reader to decorate the InputStreamReader.
5.	Use the PrintWriter to decorate the client output stream.
6.	Now read in the lines from the client and then right them on the screen, and then write an upper case version back to the client.
7.	Catch and handle the IOException.
8.	Add a finally block to close the streams, the server socket, and the socket.
9.	Compile your code and fix any errors before proceeding.

 
### Part 2 Implementing the Client
You will now implement the client application that will connect to the server application.

### Define the required variables and import the packages
1.	Define a new class called Client in a new source file called Client.java.
2.	Add import statements for the java.net and the java.io packages.
3.	Add a main method.
4.	Define a String called host which is either set to localhost, or the IP address of the machine of the person you are working with.
5.	Define an int called port, and set it to the port number 8081 used by the server application.
6.	Declare a variable of type Socket called clientSocket. This will be your socket to the server.
7.	Declare a buffered reader called keyboard and assign it to null.
8.	Declare an InputStreamReader (isr), a BufferedReader (br) , and a PrintWriter (out), and assign them all to null. Ensure that the PrintWriter is set to autoflush using the boolean constructor parameter.
### Create a connection to the server
1.	Add a try block and instantiate your clientSocket object, passing in your server socket string and the port number to the constructor.
2.	Get the OutputStream from the clientSocket, and decorate it with a new PrintWriter, assigning the return to the variable you declared earlier called out.
3.	Decorate System.in using the InputStreamReader, assigning the return to your isr variable.
4.	Decorate the InputStreamReader using the BufferedInputStream, assigning the return to your br variable.
5.	Read information from the keyboard and send it to the server until the user types ‘Quit’. You can do this using the following line of code:

while (!(line = keyboard.readLine()).equals("quit"))

6.	Print out the response from the server each time you send a line to the server to the console using System.out. You can do this by writing out the content from the BufferedReader using br.readLine().
7.	Catch the IOException, and add a finally block to close the socket and the streams.

### Part 3 Optional Make your server class multithreaded
Currently, your server application is single threaded and can only process one client. Try extending your application so that it can handle multiple client requests. You will need a new Thread on the server for each client. The client application will not change.
 
## Appendix B Inner Classes
### The Aims
In the last exercise you created a TreeSet that worked in conjunction with a Comparator to order the items in the collection. You will modify this application to use a nested class, a local class, and an anonymous class.

### Part 1 Creating a Nested Class
1.	Modify your previous exercise so that the AccountComparator class is a nested class within the CollectionsTest class.
2.	Ensure that the class definition is private and static.
3.	Run your application again to ensure that it continues to work correctly.

### Part 2 Creating a Local Class
4.	Modify the application again so that the AccountComparator is now local to the main method.
5.	Insert a new line at the beginning of main to declare a simple int with a value of 5.
6.	Try accessing the variable from within your compare method in some way by perhaps trying to print it to the screen. What happens and why?
7.	Change the variable declaration so that it can be accessed from the local class.
8.	Run the application again to ensure that it continues to work correctly.

### Part 3 Creating an Anonymous Class
9.	Modify the application again, so that the AccountComparator is declared as an anonymous inner class.
10.	Run the application again to ensure that it continues to run correctly.
11.	Finally, using Windows Explorer, take a look in the Project folder for the project containing your exercise files. What do you notice about the created class files?

 
 
## Appendix C: File IO
### The Aims
In this chapter you will process a file path and check that it is a directory, and if it is, list the contents of a directory. You will then create a file copying program that will read a file and copy the contents in a different location.

### Part 1 Using the java.io.File class
1.	Create a new Java class with a main method called DirList.java.
2.	Create a File object based upon a folder on your computer, such as c:\Program Files.
3.	Using the File class methods, check that the directory exists, and print out a message to say if it does or not.
4.	Now check that the path is a directory and not just a simple file. If it is not a directory, display a message and exit.
5.	Finally, list the contents of the directory on the console. 

### Part 2 Using the Stream Classes

What we will do in this part of the practical is implement a file copying program, using readers and writers. We will assume a similar scenario to the previous part of the practical, except this time we will be expecting two parameters on the command line, and this time they will both be files. Instructions for how to do this using Eclipse are found at the end of the exercise. If you are using a different tool or are unsure how to do it from the command line, then ask your instructor for help.

1.	Create a new Java class with a main method called FileCopier.java.
2.	Create a File object to refer to the first file name passed in on the command line.

File in = new File(args[0];

3.	Create a second File object to reference the second command line argument which will be the file that you are going to write.
4.	Check that the file you are going to read exists (use the exists() method). You cannot read a file that isn’t there! If it does not exist, exit the application with a suitable message.
5.	Check that the second argument file does not exist, and if it does, warn the user that they will have overwritten the file that was there. 
6.	To read in the file, use a FileReader decorated with a BufferedReader and read in the file line by line.
7.	As you process each line, use a FileWriter decorated with a BufferedWriter to write the output to the target file.
8.	You can use the newline() method of the BufferedWriter to put new lines between each write.
9.	Flush and close the output streams.
10.	Your code should look something like this:
File in = new File(args[0]);
File out = new File(args[1]);
		
```
try {
	FileReader reader = new FileReader(in);
	BufferedReader bReader = new BufferedReader(reader);
			
	FileWriter writer  = new FileWriter(out);	
	BufferedWriter bWriter = new BufferedWriter(writer);
			
	while (true) {
		String line = bReader.readLine();
		if (line == null) break;
		bWriter.write(line);	
		bWriter.newLine();		
	}
	bWriter.flush();
	bWriter.close();
}		
catch (FileNotFoundException e) {
	e.printStackTrace();
}
catch (IOException e) {
	e.printStackTrace();
}
```

### Part 3 Running the Program

Eclipse users

To pass a parameter at the command line when the program runs. 

1.	Click Run, and then click Run Configurations (see Figure 5).

2.	At the Create, manage and run configurations dialog, check the the project refers to your project and the Main Class refers to your FileCopier program.

3.	Click the Arguments tab. In the Program Arguments text area, enter your file names as arguments separated by a space.

 ### Optional Part

The practical you have just completed simply assumed that if the output file already exists, then it will write to a default location – even if that default location already exists!

Expand your previous work so that if the output file already exists, the program prompts the user to see if they wish to overwrite the existing file, or specify a different target instead. To do this, you will need to process System.in.
 
 
## Appendix D: Introduction to JDBC

### Aims

In this lab, you will create a connection to a database.  The table in the database will contain information about people.  You will retrieve this information and display it. The database used is an Access Database. The driver used will be the Type 1 JDBC-ODBC Bridge Driver.

### Preparation: Setting up an ODBC Datasource

You will be using an ODBC data source called ‘people’ for this application. It will link to an Access database.

1.	From Windows, click Start, point to Settings, and then click Control Panel.

2.	Launch the Data Sources (ODBC) (on XP, this will be in the Administrative Tools section).

3.	From the ODBC Data Source Administrator dialog, select the System DSN tab.

4.	Click Add, and select the Microsoft Access Driver (*.mdb).

5.	From the ODBC Microsoft Access Setup dialog. Set the Data Source Name field to people.

6.	From the ODBC Microsoft Access Setup dialog, click Select.

7.	From the Select Database dialog, browse to <LAB_HOME>\labs\jdbc\people.mdb. This is the Access database.

8.	Click OK to dismiss the Select Database dialog.

9.	Click OK to dismiss the ODBC Microsoft Access Setup dialog.	

10.	Click OK to dismiss the ODBC Data Source Administrator. 

You have now setup the database to be available with the name people, through ODBC.

###  Part 1 Create a connection

1.	Open <LAB_HOME>\labs\jdbc\PersonConnector.java in your text editor or IDE.

2.	Import the appropriate package.

3.	In the main method and within the try block, load the driver using Class.forName(“sun.jdbc.odbc.JdbcOdbcDriver”);

4.	Create a new connection using the driver.  Your code will look something like this:

```
Connection conn = DriverManager.getConnection (“jdbc:odbc:people”);
```

If there are any changes to this due to your classroom environment, your instructor will inform you. 

### Part 2 Retrieving the Data
1.	Use the connection to create a new Statement

2.	Create a String and give it the value “select * from people”

3.	Use the executeQuery method on the Statement, passing in your String, to get a ResultSet

4.	Now loop through the ResultSet and display the data using System.out.println() statements.  The data in the table includes the following:

|Column Name	|Data Type|
|-|-|
|Name|	String|
|Age|	Int|
|Gender|	String|

5.	At the end of each iteration, add an empty line.

6.	Finally, you need to close your connection and statement objects. Do this from the finally block. Remember that the close method on each throw SQLExceptions, you will need to nest a try / catch block in your finally block.

### Part 3 Adding Search Capability

In this section we are going to take an argument from the command line and use it to perform searches.  A user will pass a name to search on, and the class will return the relevant details. To use the command line, use the Run Dialog described in the File IO exercise (see Figure 5).

1.	Open <LABS_HOME>\labs\jdbc\DynamicPersonConnector.java.

2.	(optional) Add some code to check that an argument has been passed into the main method

3.	Declare a String called argument and assign it the value args[0]

4.	Underneath the code which establishes a Connection, use the connection to prepare a Statement with the text: “select * from people where name = ?”

5.	Use the PreparedStatement’s setString() method to set the first parameter to argument

6.	Obtain a ResultSet by calling the executeQuery() method on the PreparedStatement.

7.	Add the clean up code as you did previously to close the connection and the statement.

8.	Compile and run the class and pass in some test parameters.  E.g. 
```
java DynamicPersonConnector Paul 
```
