public class PersonComparator implements java.util.Comparator<Person>
{
	public int compare(Person p1, Person p2)
	{
		return ( p2.getAge() - p1.getAge() );
	}
}