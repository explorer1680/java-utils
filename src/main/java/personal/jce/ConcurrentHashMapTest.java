package personal.jce;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
	    Map<String, String> algorithmsMap = new ConcurrentHashMap<String, String>();
	    algorithmsMap.put("A", "ab");
	    algorithmsMap.put("B", "cd");
	    algorithmsMap.put("A1", "12");
	    
	    System.out.println(algorithmsMap.size());
	    System.out.println(algorithmsMap.get("A"));
	}

}
