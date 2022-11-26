package quickcheck;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicate {

	public static void main(String args[]) {

		printDuplicateCharacters2("Simplilearn");

	}
	
	
	
	public static void printDuplicateCharacters2(String word) {
		
		Arrays.stream(word.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() >1 ).forEach(System.out::println);
				
	}

	public static void printDuplicateCharacters(String word) {

		char[] characters = word.toCharArray();
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (Character ch : characters) {

			if (charMap.containsKey(ch)) {

				charMap.put(ch, charMap.get(ch) + 1);

			} else {

				charMap.put(ch, 1);

			}

		}

		Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();

		System.out.printf("List of duplicate characters in String '%s' %n", word);

		for (Map.Entry<Character, Integer> entry : entrySet) {

			if (entry.getValue() > 1) {

				System.out.printf("%s: %d %n", entry.getKey(), entry.getValue());

			}

		}

	}

}