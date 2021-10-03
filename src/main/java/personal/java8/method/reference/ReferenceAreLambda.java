package personal.java8.method.reference;

import java.util.function.Function;

public class ReferenceAreLambda {
	public static void printFunction(Function<String, String> func) {
		System.out.println(func);
	}

	public static void main(String[] args) {
		printFunction(String::valueOf);
	}
}
