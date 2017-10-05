public class PersonComparator implements java.util.Comparator
{
	public int compare(Object p1, Object p2)
	{
		Person person1 = (Person)p1;
		Person person2 = (Person)p2;
		return ( person2.getAge() - person1.getAge() );
	}
}