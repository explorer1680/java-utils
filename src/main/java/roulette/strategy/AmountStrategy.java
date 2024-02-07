package roulette.strategy;

public abstract class AmountStrategy {

    abstract public int betAmount();

    abstract public void isLostInLastBet(boolean isLost);

//    abstract public int getTotalLost();

}
