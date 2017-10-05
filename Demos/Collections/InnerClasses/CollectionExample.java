import java.util.*;

public class CollectionExample
{
	private Set personSet;

	// Creates a collection of person objects when the CollectionExample
	// is created.
	public CollectionExample()
	{
		personSet = new TreeSet(new InnerComparator());
		for (int i=0; i<5; i++)
		{
			Person p = new Person();
			p.setAge((int)(Math.random() * 100) );
			personSet.add(p);
		}
   }

   public Collection getCollection()
   {
	   return personSet;
   }

	private class InnerComparator implements Comparator
	{
		public int compare(Object p1, Object p2)
		{

			Person person1 = (Person)p1;
			Person person2 = (Person)p2;
			return ( person2.getAge() - person1.getAge() );
		}
	}

}