package personal.java8.method.reference;

interface Sayable {
	void say();//the method name is say()
}

public class StaticMethod {
	public static void saySomething() {//the method name is not say()
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = StaticMethod::saySomething;
		// Calling interface method
		sayable.say();
	}
}
