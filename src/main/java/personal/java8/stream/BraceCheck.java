package personal.java8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BraceCheck {
	
	static Map<String, String> map = new HashMap<>();
	static String matchBracket = ")]}";


	public static void main(String[] args) {
		
		BraceCheck.map.put(")", "(");
		BraceCheck.map.put("]", "[");
		BraceCheck.map.put("}", "{");
		
		
		String bracket = "{[()]}";

		String s = "xx{y[y[xx(ere)f]g(f)h]dfdjgj}dfg";

		LinkedList ll = new LinkedList();

		List l = Arrays.asList(s.split("")).stream().filter(p -> bracket.contains(p)).collect(Collectors.toList());
		
		ll.addAll(l);
		
		LinkedList<String> result = reduceBracketPair(ll);
		
		if(result == null){
			System.out.println("False");
		}else if(result.size() == 0){
			System.out.println("True");
		}else{
			System.out.print("?");
		}

	}
	

	static LinkedList<String> reduceBracketPair(LinkedList<String> strList) {
		
		

		if (strList.isEmpty() || strList == null) {
			return strList;
		} else {
			String firstRightBrachet = strList.stream().filter(p -> BraceCheck.matchBracket.contains(p)).findFirst().get();
			int position = strList.indexOf(firstRightBrachet);
			if (position == 0) {
				return null;
			} else if (strList.get(position - 1).equals(BraceCheck.map.get(firstRightBrachet))) {
				strList.remove(position - 1);
				strList.remove(position - 1);
				return reduceBracketPair(strList);
			} else {
				return null;
			}
		}
	}

}
