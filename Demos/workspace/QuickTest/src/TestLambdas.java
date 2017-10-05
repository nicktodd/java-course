import java.util.Set;
import java.util.TreeSet;

public class TestLambdas {
	
	public static void main(String[] args) {
		
		Set<Person> mySet = new TreeSet<Person>(
				(p1,p2) -> { 
									return p1.getAge() - p2.getAge(); 
								} );
		
		
		
		 new Thread(() -> System.out.println("hello")).start();
		
		
		Maths myMaths = (a,b) -> {
			return a + b;
		};
		
		myMaths.add(1, 2);
	}

}

interface Maths {
	int add(int a, int b);
}
