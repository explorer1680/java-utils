package roulette.strategy;

public class Add1For2ConsecutiveLoss extends AmountStrategy{

    private int betAmount = 1;
    private int lostTimes = 0;

    private int totalLost = 0;

    @Override
    public int betAmount() {
        if(lostTimes == 2){
            betAmount++;
            lostTimes = 0;
        }else {

            if(totalLost == 0){
                betAmount = 1;
            }else if(totalLost > 0 && totalLost < betAmount){
                betAmount = totalLost;
            }
        }
        return betAmount;
    }

    @Override
    public void isLostInLastBet(boolean isLost){
        if(isLost){
            lostTimes ++;
            totalLost = totalLost + betAmount;
        }else {
            if( lostTimes != 0) {
                lostTimes--;
            }
            totalLost = totalLost - betAmount;
            if(totalLost < 0){
                totalLost = 0;
            }
        }
    }


//    @Override
    public int getTotalLost() {
        return totalLost;
    }
}
