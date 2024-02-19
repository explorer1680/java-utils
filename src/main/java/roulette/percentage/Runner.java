package roulette.percentage;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        int initBetValue = 4;
        int maxBetValue = 10;
        int maxLoss = (initBetValue + maxBetValue)*(maxBetValue - initBetValue + 1)/2;
        float totalPercentage = 0l;

        System.out.println("Max loss Value: " + maxLoss);

        List<List<Result>> list = new ArrayList<>();
        List<Result> list1 = new ArrayList<>();
        list1.add(Result.WIN);
        List<Result> list2 = new ArrayList<>();
        list2.add(Result.LOSS);
        list.add(list1);
        list.add(list2);

        List<List<Result>> nextList = new ArrayList<>();
        int round = 0;
        float eu = 0;
        while (round <100) {
            nextList = new ArrayList<>();
            round++;
//            System.out.printf("bet in %s round: \n", rount);
            float winPercentage = 0;
            float lostPercentage = 0;
            for (List<Result> innerList : list) {
                long winCounts = innerList.stream().filter(e -> e == Result.WIN).count();
                long lostCounts = innerList.stream().filter(e -> e == Result.LOSS).count();
//                winPercentage = 0l;
//                lostPercentage = 0l;
                if(winCounts - lostCounts == initBetValue ||
                        (
                                (winCounts >= lostCounts) && (
                                        (lostCounts == 1 && winCounts - lostCounts == 3) ||
                                                (lostCounts == 3 && winCounts - lostCounts == 2) ||
                                                (lostCounts == 6 && winCounts - lostCounts == 1)
                                )
                        )
                ){//if win,
                    winPercentage += innerList.stream().map(Result::getPossibility).reduce(1f, (a, b) -> a*b);

                }else if(lostCounts - winCounts == (maxBetValue - initBetValue + 1)){//if loss
                    lostPercentage += innerList.stream().map(Result::getPossibility).reduce(1f, (a, b) -> a*b);

                }else{//continue
                    List<Result> innerList1 = new ArrayList<>(innerList);
                    innerList1.add(Result.WIN);
                    List<Result> innerList2 = new ArrayList<>(innerList);
                    innerList2.add(Result.LOSS);
                    nextList.add(innerList1);
                    nextList.add(innerList2);
                }

            }
            totalPercentage += winPercentage;
            totalPercentage += lostPercentage;
            if(winPercentage != 0f){
                System.out.printf("the winning percentage in round: \t%s is: \t%s\n", round, winPercentage);
                eu += winPercentage * 10;
            }
            if(lostPercentage != 0f){
                System.out.printf("the loss percentage in round: \t\t%s is: \t\t\t\t%s\n", round, lostPercentage);
                eu += -lostPercentage * (maxLoss-(round-(maxBetValue - initBetValue + 1))/2);
            }
            System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttotal percentage: %s, total EV: %s\n", totalPercentage, eu);
            list = nextList;

        }

    }
}
