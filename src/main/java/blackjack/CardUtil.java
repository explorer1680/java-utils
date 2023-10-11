package blackjack;

import java.util.HashMap;
import java.util.Map;

public class CardUtil {

    public static Map<String, Integer> cardPoint = new HashMap<>();

    static {
        cardPoint.put("A", 1);
        cardPoint.put("2", 2);
        cardPoint.put("3", 3);
        cardPoint.put("4", 4);
        cardPoint.put("5", 5);
        cardPoint.put("6", 6);
        cardPoint.put("7", 7);
        cardPoint.put("8", 8);
        cardPoint.put("9", 9);
        cardPoint.put("10", 10);
        cardPoint.put("J", 10);
        cardPoint.put("Q", 10);
        cardPoint.put("K", 10);
    }
}
