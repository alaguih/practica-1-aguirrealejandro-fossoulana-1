package test;
import static org.junit.Assert.*;

import main.Card;
import org.junit.Test;

public class TestsCard {

    @Test
    public void testConstructorCarta(){
        Card c = new Card(2, "golds");
        assertEquals("The number of card is 2",2,c.getNumCard());
        assertEquals("The suit of card is Golds","golds",c.getSuitCard());
    }

    @Test
    public void testgetNumCard(){
        Card c = new Card(2, "golds");
        assertEquals("The number of card is: ", 2, c.getNumCard());
    }

    @Test
    public void testgetSuit(){
        Card c = new Card(2, "golds");
        assertEquals("The number of card is: ", "golds", c.getSuitCard());
    }

    @Test
    public void testEqualsCard(){
        Card c = new Card(4, "cups");
        Card c2 = new Card(4, "cups");
        assertTrue("Are the same cards: ", c.equals(c2));
    }

}
