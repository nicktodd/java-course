import java.io.Serializable;

public class SerializablePerson  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name2;
	private int age;
	private String height;
	private String weight;
	
	
	
	
	

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name) {
		this.name2 = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
