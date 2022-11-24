package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbers {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 9, 0, 4, 5, 6, 7};
		List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
		System.out.println(list.get(list.size() - 2));
	}

}
