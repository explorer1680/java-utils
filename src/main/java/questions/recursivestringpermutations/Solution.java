package questions.recursivestringpermutations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args){
        String str = "caa";

        getPermutations(str).stream().forEach(System.out::println);

        Set<String> result = new HashSet<>();

        StringBuilder sb2 = new StringBuilder();
        String reversdStr = sb2.append(str).reverse().toString();
//        System.out.println(reversdStr);

        String[] strArray = str.split("");
        for(int i = 0; i < strArray.length; i++){
            for(int j = 0; j < strArray.length; j++){
                if(i == j) continue;
                for(int k = 0; k <strArray.length; k++){
                    if(i == k || j == k) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(strArray[i]);
                    sb.append(strArray[j]);
                    sb.append(strArray[k]);
                    result.add(sb.toString());
                }
            }
        }
//        result.stream().forEach(System.out::println);

}

public static Set<String> getPermutations(String inputString) {

        // base case
        if (inputString.length() <= 1) {
        return new HashSet<>(Collections.singletonList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);

        // recursive call: get all possible permutations for all chars except last
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

        // put the last char in all possible positions for each of the above permutations
        Set<String> permutations = new HashSet<>();
        for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
        for (int position = 0; position <= allCharsExceptLast.length(); position++) {
        String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar
        + permutationOfAllCharsExceptLast.substring(position);
        permutations.add(permutation);
        }
        }

        return permutations;
        }
}