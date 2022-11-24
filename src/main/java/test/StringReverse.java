package test;

public class StringReverse {

	public static void main(String args[]) {

		String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";

//		String reverse = new StringBuffer(str).reverse().toString();
		String reverse = StringReverse.reverse(str);

		System.out.printf("Actual Word: %s, Word after reversing %s", str, reverse);

			
	}

	public static String reverse(String source) {

		if (source == null || source.isEmpty()) {

			return source;

		}

		StringBuffer reverse = new StringBuffer();

		for (int i = source.length() - 1; i >= 0; i--) {

//			reverse = reverse + source.charAt(i);
			reverse.append(source.charAt(i));

		}

		return reverse.toString();

	}

}