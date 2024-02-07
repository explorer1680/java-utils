package roulette.resultsequence;

import java.util.Arrays;
import java.util.List;

public class RedBlackMapper {
    private static int zeroAccount = 0;
    private static List<String> RED_LIST = Arrays.asList("1", "3", "5", "7", "9", "12", "14", "16", "18", "19", "21", "23", "25", "27", "30", "32", "34", "36");
    private static List<String> BLACK_LIST = Arrays.asList("2", "4", "6", "8", "10", "11", "13", "15", "17", "20", "22", "24", "26", "28", "29", "31", "33", "35");
    private static List<String> ZERO_LIST = Arrays.asList("0");

    public static RedBlack map(String str){
        if(RED_LIST.contains(str)){
            return RedBlack.RED;
        }else if(BLACK_LIST.contains(str)){
            return RedBlack.BLACK;
        }else if(ZERO_LIST.contains(str)){
            System.out.printf("++++++++++++++++++ %s ++++++++++++++++++\n", ++zeroAccount);
            return RedBlack.ZERO;

        }else {
            throw new Error("not a valid result: " + str);
        }
    }
}
