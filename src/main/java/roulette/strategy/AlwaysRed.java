package roulette.strategy;

import roulette.resultsequence.RedBlack;

public class AlwaysRed extends BetStrategy{
    @Override
    public RedBlack bet() {
        return RedBlack.RED;
    }

    @Override
    public void inputCurrentResult(RedBlack currentResult) {
        //do nothing
    }
}
