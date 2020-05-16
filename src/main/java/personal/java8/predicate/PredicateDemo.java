package personal.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("abcd", "affedd", "cdef", "1245", "awww");
		Predicate<String> p = t -> t.startsWith("a");
		
//		list.stream().filter(p.and(t -> t.length()==4)).forEach(System.out::println);
		list.stream().filter(p.and(t -> t.length()==4).and(t -> t.endsWith("d"))).forEach(System.out::println);

	}

}
