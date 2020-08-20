package personal.java8.method.call;

import java.util.function.Consumer;

@FunctionalInterface
interface FInterface {
	void doSomething(String msg);
}

public class MethodCall implements FInterface {

	public static void main(String[] args) {
		FInterface fInterface = new MethodCall();
		fInterface.doSomething("Hello");

		FInterface fInterface2 = t -> {
			System.out.println(t);
		};
		fInterface2.doSomething("World");
		
		MethodCall methodCall = new MethodCall();
		methodCall.acceptSomething(fInterface);
		methodCall.acceptConsumer(System.out::println);
		
		//pass a lambda function, "msg" is a placeholder, not a real parameter
		methodCall.acceptSomething(msg ->{System.out.println(msg);});
		methodCall.acceptConsumer(msg ->{System.out.println(msg);});

	}

	@Override
	public void doSomething(String msg) {
		System.out.println(msg);
	}

	public void acceptSomething(FInterface doSometing) {
		doSometing.doSomething("It look good!");
	}
	
	//"HHH" will passed as a "msg".
	public void acceptConsumer(Consumer<String> consumer) {
		consumer.accept("HHH");
	}
}
