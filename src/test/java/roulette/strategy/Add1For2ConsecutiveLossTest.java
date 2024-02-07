package roulette.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class Add1For2ConsecutiveLossTest {

    @Test
    public void betNeverTooBig(){
        Add1For2ConsecutiveLoss strategy = new Add1For2ConsecutiveLoss();
        ReflectionTestUtils.setField(strategy, "totalLost", 3);
        ReflectionTestUtils.setField(strategy, "betAmount", 7);
        assertEquals(3, strategy.betAmount());
    }

    @Test
    public void totalLostNeverLessThanZero(){
        Add1For2ConsecutiveLoss strategy = new Add1For2ConsecutiveLoss();
        ReflectionTestUtils.setField(strategy, "totalLost", 3);
        ReflectionTestUtils.setField(strategy, "betAmount", 7);
        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
    }

    @Test
    public void consecutiveLoss(){
        Add1For2ConsecutiveLoss strategy = new Add1For2ConsecutiveLoss();
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());
        assertEquals(0, strategy.getTotalLost());

        strategy.isLostInLastBet(true);
        assertEquals(1, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());
        assertEquals(1, strategy.getTotalLost());

        strategy.isLostInLastBet(true);
        assertEquals(2, strategy.getTotalLost());
        assertEquals(2, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(4, strategy.getTotalLost());
        assertEquals(2, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(6, strategy.getTotalLost());
        assertEquals(3, strategy.betAmount());
        assertEquals(6, strategy.getTotalLost());
    }

    @Test
    public void winAddLossFlip_1(){
        Add1For2ConsecutiveLoss strategy = new Add1For2ConsecutiveLoss();
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(1, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(1, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());
        assertEquals(1, strategy.getTotalLost());

        strategy.isLostInLastBet(true);
        assertEquals(2, strategy.getTotalLost());
        assertEquals(2, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(4, strategy.getTotalLost());
        assertEquals(2, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(6, strategy.getTotalLost());
        assertEquals(3, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(9, strategy.getTotalLost());
        assertEquals(3, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(12, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(16, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(12, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(8, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(4, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());
    }

    @Test
    public void winAddLossFlip_2(){
        Add1For2ConsecutiveLoss strategy = new Add1For2ConsecutiveLoss();
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(1, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(1, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());
        assertEquals(1, strategy.getTotalLost());

        strategy.isLostInLastBet(true);
        assertEquals(2, strategy.getTotalLost());
        assertEquals(2, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(4, strategy.getTotalLost());
        assertEquals(2, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(6, strategy.getTotalLost());
        assertEquals(3, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(9, strategy.getTotalLost());
        assertEquals(3, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(12, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(true);
        assertEquals(16, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(12, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(8, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(4, strategy.getTotalLost());
        assertEquals(4, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());

        strategy.isLostInLastBet(false);
        assertEquals(0, strategy.getTotalLost());
        assertEquals(1, strategy.betAmount());
    }
}