package blackjack;

import org.junit.Test;
import org.mockito.internal.matchers.Equals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnfinishedCardTest {

    @Test
    public void card10_10test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("10");
        cardList.add("10");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(20, cards.calculateCards().getSum());
        assertEquals(Status.OK, cards.calculateCards().getStatus());
    }

    @Test
    public void card10_6test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("10");
        cardList.add("6");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(16, cards.calculateCards().getSum());
        assertEquals(Status.NOT_FINISHED, cards.calculateCards().getStatus());
    }

    @Test
    public void cardA_10test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("10");
        cardList.add("A");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(21, cards.calculateCards().getSum());
        assertEquals(Status.OK, cards.calculateCards().getStatus());
    }

    @Test
    public void card7_9_6test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("7");
        cardList.add("9");
        cardList.add("6");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(22, cards.calculateCards().getSum());
        assertEquals(Status.BUST, cards.calculateCards().getStatus());
    }

    @Test
    public void cardA_A_10test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("A");
        cardList.add("10");
        cardList.add("A");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(12, cards.calculateCards().getSum());
        assertEquals(Status.NOT_FINISHED, cards.calculateCards().getStatus());
    }

    @Test
    public void cardA_A_A_10test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("A");
        cardList.add("A");
        cardList.add("10");
        cardList.add("A");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(13, cards.calculateCards().getSum());
        assertEquals(Status.NOT_FINISHED, cards.calculateCards().getStatus());
    }

    @Test
    public void cardA_A_10_10test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("A");
        cardList.add("10");
        cardList.add("A");
        cardList.add("10");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(22, cards.calculateCards().getSum());
        assertEquals(Status.BUST, cards.calculateCards().getStatus());
    }

    @Test
    public void cardA_A_A_10_10test(){
        List<String> cardList = new ArrayList<>();
        cardList.add("A");
        cardList.add("10");
        cardList.add("A");
        cardList.add("A");
        cardList.add("10");
        UnfinishedCard cards = new UnfinishedCard(cardList, 0.1);
        assertEquals(23, cards.calculateCards().getSum());
        assertEquals(Status.BUST, cards.calculateCards().getStatus());
    }
}
