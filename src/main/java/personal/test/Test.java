package personal.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
//		Arrays.stream("123, 456, 789".replaceAll("\\s+","").split(",")).forEach(System.out::println);
//		Arrays.stream("123, 456, 789".split(",")).forEach(String::trim);//.forEach(System.out::println);
//		Arrays.stream("123, 456, 789".split(",")).map(String::trim).forEach(System.out::println);
//		Arrays.stream("123, 456, 789".split(",")).map(String::trim).map(e->"localhost:" + e).forEach(System.out::println);
		String result = Arrays.stream("123, 456, 789".split(",")).map(String::trim).map(e->"localhost:" + e).collect(Collectors.joining(","));
		System.out.println(result);
	
	System.out.println(true & true);
	System.out.println(true & false);
	System.out.println(false & true);
	System.out.println(false & false);
	}

}
