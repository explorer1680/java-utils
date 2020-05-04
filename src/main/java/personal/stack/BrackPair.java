package personal.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import personal.java8.stream.BraceCheck;

public class BrackPair {
	
	public static void main(String[] args){
		String s = "xx{y[y[xx(ere)f]g(f)h]dfdjgj}dfg";

		String bracket = "{[()]}";
		
		String bracketLeft = "{[(";
		
		Map<String, String> map = new HashMap<>();
		map.put(")", "(");
		map.put("]", "[");
		map.put("}", "{");
		
		List<String> list = Arrays.stream(s.split("")).filter(p-> bracket.contains(p)).collect(Collectors.toList());
		
		list.stream().forEach(System.out::print);
		System.out.println();
		
		Stack<String> stack = new Stack<>();
		
		boolean result = false;
		for(String str: list){
			if(bracketLeft.contains(str)){
				stack.push(str);
			}else{
				if(stack.isEmpty()){
					break;
				}
				String popStr = stack.pop();
				if(!map.get(str).equals(popStr)){
					break;
				}
			}
		}
		if(stack.isEmpty()){
			result = true;
		}
		
		System.out.println(result);
		
		
	}

}
