import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {

	public static void main(String[] args) {
		
		// has a parameter and a return
		Function<Integer, String> myFunc  = (a) -> {
			System.out.println(a);
			return "finished";
		};
		
		Predicate<String> onlyReturnsTrueOrFalse = (s) -> true;
		
		// has a parameter only
		Consumer<Integer> myCons = (a) -> System.out.println(a++);
		
		// has a parameter only (now using shorthand :: syntax
		Consumer<Integer> myCons2 = System.out::println;
		
		// has a return value only
		IntSupplier mySupp = () -> {return 5+5;};
			
		
		List<String> strings  = new ArrayList<String>();
		strings.forEach(System.out::println);
		
		
		
		myFunc.apply(2);
		
		
		Openable op = (c,d) -> c+d;
		
		System.out.println(op.add(2,3));
		
		
		Addable add = (int  ... values) -> { 
			for(int b : values) {
				System.out.println(b);
			}
		};
	}
	
}

interface Openable {
	
	public static int getSomething() {
		return 4;
	}
	
	public default int add(int a, int b) {
		return a + b;
	}
}

interface Addable {
	public default int add(int a, int b) {
		return a - b;
	}
	
	class Person implements Openable, Addable {

		@Override
		public int add(int a, int b) {
			// TODO Auto-generated method stub
			return Addable.super.add(a, b);
		}
		
	}
}

