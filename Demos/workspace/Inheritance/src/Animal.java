public abstract  class Animal {
	public abstract void eat();	
}
class Cat extends Animal implements Pet {
	@Override
	public void eat() {
		System.out.println("cat eats");
	}

	@Override
	public void stroke() {
		System.out.println("stroke the cat");
	}
}
class Horse extends Animal implements Pet {
	public void eat() {
		System.out.println("horse eat");
	}

	@Override
	public void stroke() {
		System.out.println("stroke the horse");
		
	}
}