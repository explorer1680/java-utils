package personal.passbyvalue;

import java.util.Arrays;

public class PassByValue {

	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 1, 2, 3 };
		Arrays.stream(arr).forEach(System.out::println);

		changeValue(arr);
		Arrays.stream(arr).forEach(System.out::println);

		pointToNewArray(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}

	static void changeValue(Integer[] arr) {
		arr[1] = 100;
	}

	static void pointToNewArray(Integer[] arr) {
		arr = new Integer[] { 100, 200, 300 };
		Arrays.stream(arr).forEach(System.out::println);
	}
}
