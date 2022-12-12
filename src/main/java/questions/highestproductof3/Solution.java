package questions.highestproductof3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args){
        int[] arrayOfInts = new int[]{
                1, 10, -5, 1, -100
        };

        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < arrayOfInts.length; i++){
            for(int j = 0; j < arrayOfInts.length; j++){
                for(int k = 0; k < arrayOfInts.length; k++){
                    if(i == j || j == k || i == k){
                        break;
                    }else {
                        resultList.add(arrayOfInts[i]*arrayOfInts[j]*arrayOfInts[k]);
                    }
                }
            }
        }

        int max = resultList.stream().max(Comparator.comparing(Integer::valueOf)).get();

        System.out.println(max);

        long number = Arrays.stream(arrayOfInts).filter(i -> i<0 ).count();
        System.out.println(number);
    }
}
