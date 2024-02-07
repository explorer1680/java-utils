package roulette;

import roulette.resultsequence.RedBlack;
import roulette.resultsequence.SequenceReader;
import roulette.strategy.*;

import java.io.IOException;

public class Runner {

    private static int maxWin = 0;
    private static int maxLost = 0;
    private static int totalAmount = 0;
    private static int totalWinTimes = 0;
    private static int totalLossTimes = 0;
    private static int consecutiveWin = 0;
    private static int consecutiveLoss = 0;
    private static int maxConsecutiveWin = 0;
    private static int maxConsecutiveLoss = 0;




    public static void main(String[] args) throws IOException {
        SequenceReader sequenceReader = new SequenceReader("2024-01-20.txt");
//        BetStrategy myBetStrategy = new FlipOnResult(RedBlack.RED);
        BetStrategy myBetStrategy = new AlwaysBlack();
//        BetStrategy myBetStrategy = new AlwaysRed();
//        AmountStrategy myAmountStrategy = new Add1For2ConsecutiveLoss();
        AmountStrategy myAmountStrategy = new Add1WhenLossMinus1WhenWin();
        sequenceReader.readSequenceFile().forEach(s ->{
            RedBlack myBet = myBetStrategy.bet();
            int myAmount = myAmountStrategy.betAmount();
            if(s.equals(myBet)){//win
                totalAmount += myAmount;

                totalWinTimes++;
                consecutiveLoss = 0;
                consecutiveWin ++;
                maxConsecutiveWin = Math.max(maxConsecutiveWin, consecutiveWin);
                System.out.printf("my bet: %s, I win, my total now: %s, my max win: %s, my max loss: %s \n", myAmount, totalAmount, maxWin, maxLost);
                myAmountStrategy.isLostInLastBet(false);
            }else {//lost
                totalAmount -= myAmount;

                totalLossTimes ++;
                consecutiveWin = 0;
                consecutiveLoss ++;
                maxConsecutiveLoss = Math.max(maxConsecutiveLoss, consecutiveLoss);
                System.out.printf("my bet: %s, I loss, my total now: %s, my max win: %s, my max loss: %s \n", myAmount, totalAmount, maxWin, maxLost);
                myAmountStrategy.isLostInLastBet(true);
            }
            myBetStrategy.inputCurrentResult(s);

            maxLost = Math.min(maxLost, totalAmount);
            maxWin = Math.max(maxWin, totalAmount);
//            System.out.printf("my max win: %s, my max loss: %s \n", maxWin, maxLost);
        });

        System.out.println("total amount: " + totalAmount);
        System.out.println("Max win: " + maxWin);
        System.out.println("Max lost: " + maxLost);
        System.out.println("total Win times: " + totalWinTimes);
        System.out.println("total Loss times: " + totalLossTimes);
        System.out.println("max consecutive win: " + maxConsecutiveWin);
        System.out.println("max consecutive Loss: " + maxConsecutiveLoss);
    }

    public static void run(){

    }
}
