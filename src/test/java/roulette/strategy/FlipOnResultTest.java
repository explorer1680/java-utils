package roulette.strategy;

import org.junit.jupiter.api.Test;
import roulette.resultsequence.RedBlack;

import static org.junit.jupiter.api.Assertions.*;

class FlipOnResultTest {

    @Test
    void nextBet() {
        FlipOnResult flipOnResult = new FlipOnResult(RedBlack.RED);
        RedBlack result = flipOnResult.bet();
        assertEquals(result, RedBlack.RED);//init bed

        flipOnResult.inputCurrentResult(RedBlack.RED);
        //current flip = true
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.BLACK);//true flip

        flipOnResult.inputCurrentResult(RedBlack.RED);
        //current flip = false
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.RED);//false same

        flipOnResult.inputCurrentResult(RedBlack.BLACK);
        //current flip = true
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.RED);//true flip

        flipOnResult.inputCurrentResult(RedBlack.BLACK);
        //current flip = false
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.BLACK);//false same

        flipOnResult.inputCurrentResult(RedBlack.ZERO);
        //current flip = true
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.BLACK);//ZERO always same no matter flip

        flipOnResult.inputCurrentResult(RedBlack.BLACK);
        //current flip = true
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.RED);//true flip

        flipOnResult.inputCurrentResult(RedBlack.ZERO);
        //current flip = false
        result = flipOnResult.bet();
        assertEquals(result, RedBlack.RED);//ZERO always same
    }

    @Test
    void initRedBed() {
        FlipOnResult flipOnResult = new FlipOnResult(RedBlack.RED);
        RedBlack result = flipOnResult.bet();
        assertEquals(result, RedBlack.RED);
        assertEquals(flipOnResult.getLastBet(), RedBlack.RED);
    }


    @Test
    void initBlackBed() {
        FlipOnResult flipOnResult = new FlipOnResult(RedBlack.BLACK);
        RedBlack result = flipOnResult.bet();
        assertEquals(result, RedBlack.BLACK);
        assertEquals(flipOnResult.getLastBet(), RedBlack.BLACK);
    }

}