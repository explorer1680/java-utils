package personal.java8;

@FunctionalInterface
interface Sayable2 {
	// default method
	default void say() {
		System.out.println("Hello, this is default method");
	}

	// Abstract method
	void sayMore(String msg);

	// static method
	static void sayLouder(String msg) {
		System.out.println(msg);
	}
	
//	default String toString(){//default method can't be Object method.
//	}
}

/*
 * Java provides a facility to create default methods inside the interface.
 * Methods which are defined inside the interface and tagged with default are
 * known as default methods. These methods are non-abstract methods. You can
 * also define static methods inside the interface. Static methods are used to
 * define utility methods.
 */
public class DefaultMethod implements Sayable2{
    public void sayMore(String msg){     // implementing abstract method    
        System.out.println(msg);    
    }    
    public static void main(String[] args) {    
    	DefaultMethod dm = new DefaultMethod();    
        dm.say();                       // calling default method    
        dm.sayMore("Work is worship");      // calling abstract method    
        Sayable2.sayLouder("Helloooo...");   // calling static method    
    }  
}
