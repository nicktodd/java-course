import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;



public class TestLocalClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// here is the local class
		
		 final int myAge;
		myAge = 0;
		
		class PersonComparator implements Comparator<Person>
	    {
	      public int compare(Person p1, Person p2)
	      {
	    	System.out.println(myAge);
	        return ( p1.getAge() - p2.getAge() );
	      }
	    }
		  
	    // working with a TreeSet (which is sorted)
	    Set<Person> personSet = new TreeSet<Person>(new PersonComparator());
	    for (int i=0; i<5; i++)
	    {
	      Person p = new Person();
	      p.setAge((int)(Math.random() * 100) );
	      personSet.add(p);
	      System.out.println("the age going in is " + p.getAge());
	    }
	    // when displayed they come back sorted!!
	    Iterator<Person> iter = personSet.iterator();
	    while (iter.hasNext())
	    {
	      Person current =  iter.next();
	      System.out.println("The age is " + current.getAge());
	    }

	  }


}
