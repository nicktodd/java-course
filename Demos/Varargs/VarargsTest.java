public class VarargsTest
{
	public static void main(String[] args)
	{
		String[] names =  {"rod", "jane", "freddie"};
		processArgs(names);
	}
	// this method takes in an array of Strings as an argument
	public static void processArgs(String ... args)
	{
		// use the for-each to iterate over each string
		for (String text:args)
		{
			System.out.println(text);
		}
	}
}