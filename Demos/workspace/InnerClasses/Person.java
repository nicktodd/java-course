
// Person class that implements Comparable and has a
// compareTo method
public class Person implements Comparable{
	
	
	private String name;
	private String gender;
	private int age;

	public Person(String name, int age)
	{
		this.name=name;
		this.age=age;
	}

	public Person() {}

	public String getName(){
		return name;
	}

	public String getGender(){
		return gender;
	}

	public int getAge(){
		return age;
	}

	
	public void setName(String s){
		name = s;
	}

	public void setGender(String s){
		if((s.equals("male"))||(s.equals("female"))){
			gender = s;
		}
	}

	public void setAge(int i){
		age = i;
	}


	// get them into ascending age order
	public int compareTo(Object obj)
	{
		Person otherPerson = (Person) obj;
		return  otherPerson.age - this.age ;
	}
}
