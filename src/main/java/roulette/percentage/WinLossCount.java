package roulette.percentage;

public class WinLossCount {
    private final int winCount;
    private final int lossCount;

    private final double percentage;

    public WinLossCount(int winCount, int lossCount, double percentage){
        this.winCount = winCount;
        this.lossCount = lossCount;
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinLossCount that = (WinLossCount) o;

        if (winCount != that.winCount) return false;
        return lossCount == that.lossCount;
    }

    @Override
    public int hashCode() {
        int result = winCount;
        result = 31 * result + lossCount;
        return result;
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
}
