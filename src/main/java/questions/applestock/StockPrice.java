package questions.applestock;

public class StockPrice {

    public static void main(String[] args){

//        int[] stockPriceOfTheDay = new int[]{
//                10, 20, 50, 110, 70, 25, -115, 100, -12, 2, 33, 50, 90
//        };

        int[] stockPriceOfTheDay = new int[]{
                100,90,80, 70, 60, 50, 40, 30, 20, 10
        };

        mySolution(stockPriceOfTheDay);
        betterSolution(stockPriceOfTheDay);

    }

    private static void mySolution(int[] stockPriceOfTheDay) {
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < stockPriceOfTheDay.length; i++){
            for(int j = i+1; j< stockPriceOfTheDay.length; j++){
                int interProfit = stockPriceOfTheDay[j] - stockPriceOfTheDay[i];
                if (interProfit > maxProfit){
                    maxProfit = interProfit;
                }
            }
        }

        System.out.println(maxProfit);
    }

    private static void betterSolution(int[] stockPrices){

        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }

        System.out.println(maxProfit);
    }
}
