package blackjack;

import org.apache.kafka.connect.data.Decimal;
import sun.lwawt.macosx.CSystemTray;

import java.util.*;
import java.util.stream.Collectors;

public class Dealer10 {

    private static final String BASE_CARD = "10";

    public static void main(String[] args) {

        Map<Integer, Double> odds = new HashMap<>();

        Deque<UnfinishedCard> nodes = new ArrayDeque<>();

        double p = 1.0/13;
        for(Map.Entry<String, Integer> entry: CardUtil.cardPoint.entrySet()){
            List<String> list = new LinkedList<>();
            list.add(Dealer10.BASE_CARD);
            list.add("6");
            list.add(entry.getKey());
            nodes.push(new UnfinishedCard(list, p));
        }

        while(nodes.size() > 0){
            UnfinishedCard unfinishedCard = nodes.pop();
            MiddleResult result = unfinishedCard.calculateCards();
            if(result.getStatus() == null){
                unfinishedCard.getCardNames().forEach(System.out::println);
                return;
            }
            if(result.getStatus() == Status.OK){
                odds.computeIfPresent(Integer.valueOf(result.getSum()), (k, v) -> v + unfinishedCard.getPossibility());
                odds.putIfAbsent(Integer.valueOf(result.getSum()), unfinishedCard.getPossibility());
            }else if(result.getStatus() == Status.BUST){
                odds.computeIfPresent(-1, (k, v) -> v + unfinishedCard.getPossibility());
                odds.putIfAbsent(-1, unfinishedCard.getPossibility());
            }else if(result.getStatus() == Status.NOT_FINISHED){
                for(Map.Entry<String, Integer> entry: CardUtil.cardPoint.entrySet()){
                    List<String> middleList = new ArrayList<>(unfinishedCard.getCardNames());
                    middleList.add(entry.getKey());
                     nodes.push(new UnfinishedCard(middleList, unfinishedCard.getPossibility()*p));
                }
            }
        }
        System.out.println(odds.entrySet().stream().collect(Collectors.summingDouble(entry -> entry.getValue())));
        odds.entrySet().stream().forEach(System.out::println);
    }
}
