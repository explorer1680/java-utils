package roulette.percentage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner2 {
    public static void main(String[] args) {

        int initBetValue = 4;
        int maxBetValue = 10;
        int maxLoss = (initBetValue + maxBetValue)*(maxBetValue - initBetValue + 1)/2;
        float totalPercentage = 0l;
        float totalWinPercentage = 0l;
        float totalLossPercentage = 0l;

        System.out.println("Max loss Value: " + maxLoss);

        List<Sequence> list = new ArrayList<>();
        Sequence win = new Sequence();
        win.addWin();
        Sequence loss = new Sequence();
        loss.addLoss();
        list.add(win);
        list.add(loss);

        List<Sequence> nextList = new ArrayList<>();
        int round = 1;
        float eu = 0;
        while (round <=100) {
            nextList = new ArrayList<>();

//            System.out.printf("bet in %s round: \n", rount);
            float winPercentage = 0;
            float lostPercentage = 0;
//            System.out.println(list);
            for (Sequence sequence : list) {
                long winCounts = sequence.getWinCount();
                long lostCounts = sequence.getLossCount();
//                winPercentage = 0l;
//                lostPercentage = 0l;
//                if(winCounts - lostCounts == initBetValue ||
//                        (
//                                (winCounts >= lostCounts) && (
//                                        (lostCounts == 1 && winCounts - lostCounts == 3) ||
//                                                (lostCounts == 3 && winCounts - lostCounts == 2) ||
//                                                (lostCounts == 6 && winCounts - lostCounts == 1) ||
//                                                (lostCounts == 10)
//                                )
//                        )
//                )
                if(winCounts - lostCounts == initBetValue){//if win,
                    winPercentage += sequence.getNumbers().doubleValue()*sequence.getPercentage();

                }else if(lostCounts - winCounts == (maxBetValue - initBetValue + 1)){//if loss
                    lostPercentage += sequence.getPercentage()*sequence.getNumbers().doubleValue();

                }else{//continue
                    Sequence sequence1 = new Sequence(sequence);
                    sequence1.addWin();
                    Sequence sequence2 = new Sequence(sequence);
                    sequence2.addLoss();
                    nextList.add(sequence1);
                    nextList.add(sequence2);
                }


            }

            totalPercentage += winPercentage;
            totalWinPercentage += winPercentage;
            totalPercentage += lostPercentage;
            totalLossPercentage += lostPercentage;
            if(winPercentage != 0f){
                System.out.printf("the winning percentage in round: \t%s is: \t%s\n", round, winPercentage);
//                eu += winPercentage * (initBetValue + 1)*initBetValue/2;
                eu += winPercentage * ((initBetValue + 1)*initBetValue/2 + (round - initBetValue)/2);
            }
            if(lostPercentage != 0f){
                System.out.printf("the loss percentage in round: \t\t%s is: \t\t\t\t%s\n", round, lostPercentage);
                eu += -lostPercentage * (maxLoss-(round-(maxBetValue - initBetValue + 1))/2);
            }
            System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttotal win: %s, total loss: %s, total percentage: %s, total EV: %s\n", totalWinPercentage, totalLossPercentage, totalPercentage, eu);

            Map<WinLossCount, BigDecimal> map = new HashMap<>();
            for(Sequence s: nextList){
                WinLossCount winLossCount = new WinLossCount(s.getWinCount(), s.getLossCount(), s.getPercentage());
                if(map.containsKey(winLossCount)){
                    map.put(winLossCount, map.get(winLossCount).add(s.getNumbers()));
                }else {
                    map.put(winLossCount, s.getNumbers());
                }
//                map.merge(winLossCount, s.getNumbers(), (k, v) -> s.getNumbers() + v);
            }

            nextList = new ArrayList<>();
            for(Map.Entry entry: map.entrySet()){
                Sequence sequenceNew = new Sequence((BigDecimal) entry.getValue(), ((WinLossCount)entry.getKey()).getWinCount(),
                        ((WinLossCount)entry.getKey()).getLossCount(), ((WinLossCount)entry.getKey()).getPercentage());
                nextList.add(sequenceNew);
            }

            list = nextList;
//            System.out.println(list);


            round++;
        }

//        System.out.println(list);

        for(Sequence s: list){
            if(s.getWinCount() >= s.getLossCount()){//win
                int winAmount = 0;
                if(s.getWinCount() - s.getLossCount() == 1){
                    winAmount = s.getLossCount() + 4;
                }else if(s.getWinCount() - s.getLossCount() == 2){
                    winAmount = s.getLossCount() + 7;
                }else if(s.getWinCount() - s.getLossCount() == 3){
                    winAmount = s.getLossCount() + 9;
                }

                eu += s.getPercentage()*s.getNumbers().doubleValue()*winAmount;
            }else {//loss
                int delta = s.getLossCount() - s.getWinCount();
                int lossAmount = (initBetValue*2 + delta)*(delta + 1)/2;
                eu -= s.getPercentage()*s.getNumbers().doubleValue()*lossAmount;
            }
        }
        System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfinal EV: %s\n", eu);

    }
}
