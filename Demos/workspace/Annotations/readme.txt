Before using javac to run ToStringProcessor on Classes.java (before compiling this source file), 
we need to compile ToString.java and ToStringProcessor.java. 
Invoke the following command line to compile both of these source files:

javac ToStringProcessor.java
Assuming that ToString.java and ToStringProcessor.java compiled successfully, 
invoke the following javac command line to apply ToStringProcessor to Classes.java before compiling this source file:

javac -processor ToStringProcessor Classes.java

This example is taken from this URL:
http://tutortutor.ca/cgi-bin/makepage.cgi?/articles/byoap