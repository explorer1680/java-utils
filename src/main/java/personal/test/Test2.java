package personal.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {
		System.out.println((int)Math.round(19.9));
		
		List<String> list = new ArrayList<>();
		list.add("Test;DOM 123 a Test");
		list.add("Test;DOM 0012300 a Test");
		list.add("Test;DOM 1 a Test");
		list.add("Test;DOM abc a Test");
		
		Pattern pattern = Pattern.compile("(?<=;DOM\\s)([0-9]+)");
		
		int max = 0;
		for(String s: list) {
			try {
				 Matcher matcher = pattern.matcher(s);
				 if (matcher.find()) {
				int i = Integer.parseInt(matcher.group(1));
				if(max < i) {
					max = i;
				}
				 }
			}catch(NumberFormatException e) {
				continue;
			}
		}

		System.out.println(max);
		
		

	}
}