package test;

import main.Card;
import main.Deck;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestsDeck {

    @Test
    public void testConstructorDeck(){
        Deck d = new Deck();
        assertEquals("The number of cards are 48:",true, d.getNumCards()==48);
    }

    @Test
    public void testgetCard(){
        Deck d = new Deck();
        Card c = new Card(12, "Clubs");
        Card c1 = d.getCard();
        System.out.println(c.showCard());
        System.out.println(c1.showCard());
        assertTrue("The card is: ", c.equals(c1));
    }
}
