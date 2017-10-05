import java.util.*;

public class TestInnerClass
{
	public static void main (String[] args)
	{
		CollectionExample collExample = new CollectionExample();
		Collection col = collExample.getCollection();
		Iterator iter = col.iterator();
		while (iter.hasNext())
		{
			Person p = (Person) iter.next();
			System.out.println("age is " + p.getAge());
		}
	}


}