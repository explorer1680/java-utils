package roulette.strategy;

import roulette.resultsequence.RedBlack;

public abstract class BetStrategy {
    public abstract RedBlack bet();

    public abstract void inputCurrentResult(RedBlack currentResult);
}
