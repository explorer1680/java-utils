package personal.java8;

@FunctionalInterface
interface sayable {
	void say(String msg); // abstract method
	// It can contain any number of Object class methods.

//	int hashCode();
//	//https://stackoverflow.com/questions/8721848/overriding-object-class-methods-within-an-interface-in-java
//	//why no implements in the class.
//
//	final String toString();
//	
//	 Class<?> getClass();
//
//	boolean equals(Object obj);
}



/*
 * An Interface that contains exactly one abstract method is known as functional
 * interface. It can have any number of default, static methods but can contain
 * only one abstract method. It can also declare methods of object class.									//method of Object class is exist at least java6
 * Functional Interface is also known as Single Abstract Method Interfaces or
 * SAM Interfaces. It is a new feature in Java, which helps to achieve
 * functional programming approach.
 */
public class FunctionalInterfaces implements sayable {//you don't need to implements the Object class method.
	public void say(String msg) {
		System.out.println(msg);
	}
	
//	@Override
//	public String toString(){
//		return "abc";
//	}

	public static void main(String[] args) {
		FunctionalInterfaces fie = new FunctionalInterfaces();
		fie.say("Hello there");
		System.out.println(fie.toString());
		System.out.println(fie.getClass());
	}
}
