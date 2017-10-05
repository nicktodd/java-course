import java.util.*;

public class CollectionExamples
{




  public static void main(String[] args)
  {
    final int myInt = 6;




    // create a list of ints
    List<Integer> list = new ArrayList<Integer>(10);
    for (int i=0; i<10; i++)
    {
      list.add(new Integer(i));
    }

    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext())
    {
      System.out.println(iterator.next());
    }

    // create a set of dates
    Set<Calendar> set = new HashSet<Calendar>(10);
    for (int i=0; i<set.size(); i++)
    {
      // get a Calendar instance
      Calendar cal = Calendar.getInstance();
      // set the date for the instance
      cal.set(2004, i, 1);
      // add the instance to the set
      set.add(cal);
    }

    // working with a TreeSet (which is sorted)
    Set<Person> personSet = new TreeSet<Person>();
    for (int i=0; i<5; i++)
    {
      Person p = new Person();
      p.setAge((int)(Math.random() * 100) );
      personSet.add(p);
      System.out.println("the age going in is " + p.getAge());
    }
    // when displayed they come back sorted!!
  for (Person p : personSet)
  {
	  System.out.println("Age coming out of the set is " + p.getAge());
  }

    // create a Map of persons using the name as a key
    HashMap<String, Person> personMap = new HashMap<String, Person>();
    personMap.put("Rod", new Person("Rod", 40));
    personMap.put("Jane", new Person("Jane", 45));
    personMap.put("Freddy", new Person("Freddy", 39));

    Person p1 = personMap.get("Rod");


    Set personSetInnerClass = new TreeSet(new Comparator()
        {
          public int compare(Object p1, Object p2)
          {

            Person person1 = (Person)p1;
            Person person2 = (Person)p2;
            return ( person2.getAge() - person1.getAge() );
      }
    });



}

}