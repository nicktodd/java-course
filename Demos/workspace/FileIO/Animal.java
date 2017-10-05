import java.io.Serializable;


public class Animal implements Serializable{
	
	public Animal(String species) {
		this.species = species;
	}
	

	
	private String species;

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	

}
