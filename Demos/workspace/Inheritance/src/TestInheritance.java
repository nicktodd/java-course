import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

interface Converter  {
		double convert(double valueToConvert);		
}



public class TestInheritance {
	public static void main(String[] args) {
		
		Set<Pet> pets = new HashSet<>();
		pets.add(new Cat());
		pets.add(new Horse());
		pets.add(new Tamigotchi());
		pets.add(new Cat());
		
		for (Pet pet : pets) {
			pet.stroke();
		}
		
		
		
		
		
		
		
		Consumer<Integer> myNumberEater =  System.out::println;
		myNumberEater.accept(5);
		Supplier<String> myStringSupplier = () -> "get this";
		System.out.println(myStringSupplier.get());
		Converter celcToFarenConverter = (vToConv) -> vToConv * 9 /5 + 32;
		Converter stonesToKilograms = (vToConv) -> vToConv * 6.35029;
		System.out.println(celcToFarenConverter.convert(36.8));
		System.out.println(stonesToKilograms.convert(10));
		Function<Double,Double> feetToMetres = (feetValue) -> feetValue * 0.3048;
		System.out.println(feetToMetres.apply(3.0));
		Pet petLambda = () ->  {
			System.out.println("stroke the pet lambda");
			System.out.println("stroke the pet lambda again");
		};
		petLambda.stroke();
		
		
		Cat c = new Cat();
		Animal c1 = new Cat();
		Animal c2 = new Horse();
		Object c3 = new Cat();
		Tamigotchi c4= new Tamigotchi();
		
		
		
		
		
		
	}

}