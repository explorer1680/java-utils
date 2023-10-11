package blackjack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
@Getter
@Setter
public class UnfinishedCard {
    private List<String> cardNames;
    private Double possibility;

    public MiddleResult calculateCards(){
        AtomicBoolean flagOfA = new AtomicBoolean(false);
        int sum = cardNames.stream().map(card ->{
            if(card.equals("A") && !flagOfA.get()){
                flagOfA.set(true);
                return 0;
            }else {
                return CardUtil.cardPoint.get(card);
            }
        }).mapToInt(Integer::intValue).sum();

        if(flagOfA.get()){
            if ((sum + 11 >= 17) && (sum + 11 <=21)){
                return new MiddleResult(Status.OK,sum + 11);
            }else if((sum + 1 >= 17) && (sum + 1 <=21)){
                return new MiddleResult(Status.OK,sum + 1);
            }else if(sum + 11 < 17){
                return new MiddleResult(Status.NOT_FINISHED, sum + 11);
            }else if(sum + 1 < 17){
                return new MiddleResult(Status.NOT_FINISHED, sum + 1);
            }else if(sum + 1 > 21){
                return new MiddleResult(Status.BUST, sum +1);
            }else {
                return new MiddleResult(null, 0);
            }
        }else {
            if(sum >= 17 && sum <=21){
                return new MiddleResult(Status.OK, sum);
            }else if(sum < 17){
                return new MiddleResult(Status.NOT_FINISHED, sum);
            }else {
                return new MiddleResult(Status.BUST, sum);
            }
        }

    }
}
