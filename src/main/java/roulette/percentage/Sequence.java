package roulette.percentage;

import java.math.BigDecimal;

public class Sequence {
    private BigDecimal numbers = new BigDecimal(1);
    private int winCount;
    private int lossCount;
    private double percentage = 1f;

    public Sequence(){}

    public Sequence(Sequence s){
        this.numbers = s.numbers;
        this.percentage = s.percentage;
        this.winCount = s.winCount;
        this.lossCount = s.lossCount;
    }

    public Sequence(BigDecimal numbers, int winCount, int lossCount, double percentage){
        this.numbers = numbers;
        this.winCount = winCount;
        this.lossCount = lossCount;
        this.percentage = percentage;
    }

    public void addWin(){
        this.winCount += 1;
        this.percentage *= Result.WIN.getPossibility();
    }

    public void addLoss(){
        this.lossCount += 1;
        this.percentage *= Result.LOSS.getPossibility();
    }



    public BigDecimal getNumbers() {
        return numbers;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "numbers=" + numbers +
                ", winCount=" + winCount +
                ", lossCount=" + lossCount +
                ", percentage=" + percentage +
                '}';
    }
}
