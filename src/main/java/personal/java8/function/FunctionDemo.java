package personal.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("abcd", "affedd", "cdef", "1245", "awww");
		Function<String, String> func = t -> t +"1";
		
		list.stream().map(func.andThen(t -> t+"2").compose(t->t+"0").andThen(t->t +"3")).forEach(System.out::println);

	}

}
