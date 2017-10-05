import java.util.*;
public class CollectionsWithGenerics
{

	public static void main(String[] args)
	{
		/*List<Person> myList = new ArrayList<Person>();
		myList.add(new Person("Alex", 9));
		myList.add(new Person("Abi", 7));
		myList.add(new Person("Zach", 4));
		myList.add(new Person("Emily", 2));

		for (Person current : myList) {
			System.out.println("The name is " + current.getName());
		}

		Iterator<Person> iter = myList.iterator();
		while (iter.hasNext()) {
			Person p = iter.next();
			System.out.println("The name is " + p.getName());
		}

		*/

		Set<Person> mySet = new TreeSet<Person>(new PersonComparator());
		mySet.add(new Person("Alex", 9));
		mySet.add(new Person("Abi", 3));
		mySet.add(new Person("Zach", 40));
		mySet.add(new Person("Emily", 2));

		for (Person current : mySet) {
			System.out.println("The name is " + current.getName());
		}
/*
		Iterator<Person> iterSet = mySet.iterator();
		while (iterSet.hasNext()) {
			Person p = iterSet.next();
			System.out.println("The name is " + p.getName());
		}
*/
	}
}