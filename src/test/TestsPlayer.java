package test;

import main.Card;
import main.Player;
import main.Playerh;
import main.Table;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestsPlayer {

    @Test
    public void testConstructoPlayer(){
        Player p = new Playerh();
        assertTrue("The name fo the player is empty", p.getName().isEmpty()==true);
        assertTrue("Don't have cards", p.hand().isEmpty()==true);
    }

    @Test
    public void testConstPlayer(){
        ArrayList<Card> cards = new ArrayList<>();
        Card c = new Card(5, "Swords");
        cards.add(c);
        Player p = new Playerh("D", cards);
        assertTrue("The name of the player is D: ", p.getName()=="D");
        assertTrue("The Card of the player is 1: ", p.hand().size()==1);
    }

    @Test
    public void testcanPlay(){
        Table t = new Table();
        ArrayList<Card> cards = new ArrayList<>();
        Card c = new Card(5, "Swords");
        Card c2 = new Card(6, "Golds");
        cards.add(c2);
        Player p = new Playerh("D", cards);
        assertTrue("The player can't play: ", p.canPlayer(t)==false);
        cards.add(c);
        assertTrue("The player can play: ", p.canPlayer(t)==true);
    }

    @Test
    public void testHaveCard(){
        ArrayList<Card> cards = new ArrayList<>();
        Card c = new Card(5, "Swords");
        Card c2 = new Card(6, "Golds");
        Card c3 = new Card(8, "Cups");
        Card c4 = new Card(5, "Cups");
        cards.add(c);
        cards.add(c2);
        cards.add(c3);
        Player p = new Playerh("D", cards);
        assertTrue("They have the 8 of cups: ", p.haveCard(c3)==true);
        assertEquals("They have the 8 of cups: ", false, p.haveCard(c4));
    }

    @Test
    public void testCardLeft(){
        ArrayList<Card> cards = new ArrayList<>();
        Card c = new Card(5, "Swords");
        Card c2 = new Card(6, "Golds");
        Card c3 = new Card(8, "Cups");
        cards.add(c);
        cards.add(c2);
        cards.add(c3);
        Player p = new Playerh("D", cards);
        assertEquals("The remaining cards are 3: ", true, p.cardsLeft()==3);
        assertEquals("The remaining cards are not 4: ", false, p.cardsLeft()==4);
    }

    @Test
    public void testFinish(){
        ArrayList<Card> cards = new ArrayList<>();
        Player p = new Playerh("D", cards);
        assertEquals("The player are finish: ", true, p.finish());
        Card c = new Card(4, "Golds");
        cards.add(c);
        assertEquals("The player are not finish: ", false, p.finish());
    }

    @Test
    public void testGetCard(){
        ArrayList<Card> cards = new ArrayList<>();
        Card c = new Card(5, "Golds");
        Player p = new Playerh("D", cards);
        assertEquals("The player don't have cards: ", true, p.cardsLeft()==0);
        p.getCard(c);
        assertTrue("The player have one card: ", p.cardsLeft()==1);
    }

    @Test
    public void testHand(){
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards2 = new ArrayList<>();
        Card c = new Card(5, "Swords");
        Card c2 = new Card(6, "Golds");
        Card c3 = new Card(8, "Cups");
        cards.add(c);
        cards.add(c2);
        cards2.add(c);
        cards2.add(c2);
        cards2.add(c3);
        Player p = new Playerh("D", cards);
        assertEquals("The hand of cards are equals to cards: ", true, p.hand().equals(cards));
        assertEquals("The hand of cards are equals to cards: ", false, p.hand().equals(cards2));
    }

    @Test
    public void testGetName(){
        ArrayList<Card> cards = new ArrayList<>();
        Player p = new Playerh("D", cards);
        assertEquals("The name of the player are D: ", true, p.getName().equals("D"));
        assertEquals("The name of the player are D: ", false, p.getName().equals("Dario"));
    }
}
