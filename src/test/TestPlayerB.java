package test;

import main.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestPlayerB {
    @Test
    public void testPlayCard(){
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards2 = new ArrayList<>();
        Card c = new Card(5, "Swords");
        Card c2 = new Card(6, "Golds");
        Card c3 = new Card(8, "Cups");
        cards.add(c);
        cards.add(c2);
        cards2.add(c3);
        Player p = new Playerb("D", cards);
        Player p2 = new Playerb("M", cards2);
        Table t = new Table();
        String s = "Swords";
        p.playCard(t);
//        System.setIn(new ByteArrayInputStream("Swords".getBytes()));
//        System.setIn(new ByteArrayInputStream("5".getBytes()));
        System.out.println(t.getColumnSwords().size());
        assertEquals("The card is played: ", true, t.getColumnSwords().size()==1);
        p2.playCard(t);
        assertEquals("The card don't be played: ", false, t.getColumnSwords().size()==2);
    }

}
