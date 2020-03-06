package personal.java8.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinValue {
	public static void main(String[] args) {
		Map<String, Long> map = new HashMap<>();
		map.put("a", 10L);
		map.put("b", 100L);
		map.put("c", 110L);

		Long min = map.entrySet().stream().min(Comparator.comparing(Entry<String, Long>::getValue)).get().getValue();
		System.out.println(min);
	}
}
