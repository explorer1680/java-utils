package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		
		int[] array = new int[5];
		String[] stringArray = new String[10];
		
		String s;
		
//		System.out.println(s);
		
		String arrayS[] = new String[] {
				"abf", "dfd"
		};
		System.out.println(arrayS);
		
		Set<String> stringSet = new HashSet<>();
		
		System.out.println(stringSet);
		
        // create a HashMap and add some values
        HashMap<String, Integer> map
            = new HashMap<>();
        map.put("key1", 10000);
        map.put("key2", 55000);
        map.put("key3", 44300);
        map.put("key4", 53200);
 
        // print map details
        System.out.println("HashMap:\n "
                           + map.toString());
 
        // provide value for new key which is absent
        // using computeIfAbsent method
        map.computeIfAbsent("key5",
                            k -> 2000 + 33000);
        map.computeIfAbsent("key6",
                            k -> 2000 * 34);
 
        // print new mapping
        System.out.println("New HashMap:\n "
                           + map);
	}

}
