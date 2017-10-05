import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

interface Openable {
	void open();
}

interface Maths {

	 int add(int a, int b);

}
class PersonByNameComparator{}
class PersonByAgeComparator{}




class Person  implements Comparable<Person>{
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public Person() {
	}


	


	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		return this.age - p.age;
	}


	
	

}


public class TestLambdas {
	
	public static void main(String[] args) {
		// create the lambda instance
		// the line of code becomes the contents of the open method
		Openable myBuilding  = () -> System.out.println("Open building");
		myBuilding.open();
		
		
		
		
		// lambdas with more than one line of code in the method
		// require curly brackets
		Openable myBuilding2  = () -> {
			System.out.println("Two lines of code");
			System.out.println("Now require curly brackets");
		};
		myBuilding2.open();
		
		// now for a lambda with parameters - you can specify parameter types if you want to
		//Maths myMaths = (int op1, int op2) -> {return op1 + op2;};
		
		Set<Person> people = new TreeSet<>();
		people.add(new Person("Fred", 30));
		people.add(new Person("Barnie", 25));
		people.add(new Person("Betty", 23));
		people.add(new Person("Wilma", 28));

		
				
		people.forEach(m -> System.out.println(m.getName() + m.getAge()));
//		System.out.println(".............................");
//		p.setName("Fred");
//		people.forEach(m -> System.out.println(m.getName()));
//		System.out.println(".............................");
//		p.setAge(30);
//		
//		people.forEach(m -> System.out.println(m.getName()));
//		
		
		//String s;
		//people.forEach(p -> System.out.println(p.getName()));
		
		//people.stream().filter(p -> p.getName().startsWith("B"))
		//						.forEach(p -> System.out.println(p.getName()));
		
		//for (Person p : people) {
		//	if (p.getName().startsWith("B")) {
		//		System.out.println(p.getName());
		//	}
	//	}
		
		
		
		List<Person> newList = people.stream()
								.filter(m -> m.getAge() >= 23)
								.sorted((p1,p2) -> p1.getAge() - p2.getAge())
								.map(m -> { 
									Person p1 = new Person(m.getName().toUpperCase(), m.getAge());
									return p1;
								})
								.collect(Collectors.toList());
								//.forEach(person -> System.out.println(person.getName()));
		Iterator<Person> iter= newList.iterator();
//		newList.forEach(System.out::println);
		
		
		newList.forEach(new Consumer<Person>() {

			@Override
			public void accept(Person t) {
				System.out.println(t.getName());
				
			}
			
		});
		
	}

}
