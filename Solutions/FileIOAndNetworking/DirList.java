/**
	This is the solution for the first part of the File IO
	and Networking practical. It lists the contents of the
	directory passed as the command line argument.

	@author Mark Szolkowski
	@version 1.0
*/

import java.io.*;

public class DirList
{
	public static void main(String[] args)
	{
		// Make sure we have an argument. Grr.

		if (args.length == 0)
		{
			System.out.println("Usage: DirList <directory");
			System.out.println("\te.g.   java DirList c:\temp");
			System.exit(1);
		}

		// Construct a file object - it might not exist!

		File f = new File(args[0]);

		// See if the file or directory exists

		if (!f.exists())
		{
			System.out.println("That path !exist");
			System.exit(2);
		}

		// Now make sure it is a directory

		if (!f.isDirectory())
		{
			System.out.println("Path exists, but is not a directory!");
			System.exit(3);
		}

		// Get the contents of the directory we know exists!

		String[] contents = f.list();

		// Display the directory's contents

		for (int i=0; i<contents.length; ++i)
			System.out.println(contents[i]);
	}
}