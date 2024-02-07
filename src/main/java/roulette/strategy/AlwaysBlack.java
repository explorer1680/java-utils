package roulette.strategy;

import roulette.resultsequence.RedBlack;

public class AlwaysBlack extends BetStrategy{
    @Override
    public RedBlack bet() {
        return RedBlack.BLACK;
    }

    @Override
    public void inputCurrentResult(RedBlack currentResult) {
        //do nothing
    }
}
