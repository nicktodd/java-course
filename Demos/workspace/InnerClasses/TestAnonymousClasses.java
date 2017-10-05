import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestAnonymousClasses {

	public static void main(String[] args)
	{
		//	Create a set using an anonymous inner class for the sort
		Set<Person> personSetInnerClass = new TreeSet<Person>(new Comparator<Person>()
		    {
		      public int compare(Person p1, Person p2)
		      {


		        return ( p2.getAge() - p1.getAge() );
		  }
		});

	    for (int i=0; i<5; i++)
	    {
	      Person p = new Person();
	      p.setAge((int)(Math.random() * 100) );
	      personSetInnerClass.add(p);
	      System.out.println("the age going in is " + p.getAge());
	    }
	    // when displayed they come back sorted!!
	    Iterator<Person> iter = personSetInnerClass.iterator();
	    while (iter.hasNext())
	    {
	      Person current =  iter.next();
	      System.out.println("The age is " + current.getAge());
	    }




	}

}
