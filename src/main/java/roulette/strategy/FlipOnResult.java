package roulette.strategy;

import roulette.resultsequence.RedBlack;

public class FlipOnResult extends BetStrategy{

    private boolean flip = true;
    private boolean initBet;
    private RedBlack lastBet;
    private RedBlack currentResult;

    public FlipOnResult(RedBlack initBed){
        this.lastBet = initBed;
        this.initBet = true;
    }

    @Override
    public RedBlack bet() {
        if(this.initBet){
            this.initBet = false;
            return lastBet;
        }

        if(currentResult == RedBlack.ZERO){
            return lastBet;
        }
        flip = !flip;

        if (flip) {
            lastBet = currentResult;
            return currentResult;
        } else {
            if(currentResult == RedBlack.BLACK){
                lastBet = RedBlack.RED;
                return RedBlack.RED;
            }else {
                lastBet = RedBlack.BLACK;
                return RedBlack.BLACK;
            }
        }
    }

    @Override
    public void inputCurrentResult(RedBlack currentResult){
        this.currentResult = currentResult;
    }



    public RedBlack getLastBet(){
        return this.lastBet;
    }
}
