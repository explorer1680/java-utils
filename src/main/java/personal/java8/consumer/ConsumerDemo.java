package personal.java8.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(30);
		list.add(300);
		
		list.stream().forEach(System.out::println);
		
		System.out.println("******************************");
		
		//*************Test1
		Consumer<Integer> consumer = System.out::println;
		consumer = consumer.andThen(t-> System.out.println(++t));
//		list.stream().forEach(consumer.andThen(t-> System.out.println(t+1)));
		list.stream().forEach(((Consumer<Integer>)System.out::println).andThen(t->System.out.println(t+1)));
		
		//**************Test2
//		list.stream().map(i -> ++i).forEach(System.out::println);
//		list.stream().map(i -> i++).forEach(System.out::println);
		
		//**************Test3
//		Consumer<Integer> consumer = i -> i.sum(i, 1);
//		list.stream().map(consumer).forEach(System.out::println);
	}

}
