package test;

import main.Card;
import main.Table;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestsTable {

    @Test
    public void testConstructorTable(){
        Table t = new Table();
        assertTrue("The suit golds are right created: ", t.getColumnGolds()!=null);
        assertTrue("The suit cups are right created: ", t.getColumnCups()!=null);
        assertTrue("The suit swords are right created: ", t.getColumnSwords()!=null);
        assertTrue("The suit clubs are right created: ", t.getColumnClubs()!=null);
        //Comprobar not null y tamaño 12
    }

    @Test
    public void testCanPlay(){
        Table t = new Table();
        Card c = new Card(5, "Swords");
        Card c2 = new Card(6, "Swords");
        assertEquals("The card can be played: ", true,t.canPlay(c));
        assertEquals("The card can't be played: ", false,t.canPlay(c2));
        t.putCard(c);
        assertEquals("The card can't be played: ", true,t.canPlay(c2));
    }

    @Test
    public void testPutCard(){
        Table t = new Table();
        Card c = new Card(5, "golds");
        Card c1 = new Card(6, "golds");
        Card c2 = new Card(4, "golds");
        t.putCard(c);
        assertTrue("The card c has been placed: ", t.getColumnGolds().size()==1);
        t.putCard(c1);
        assertTrue("The card c2 has been placed: ", t.getColumnGolds().size()==2);
        t.putCard(c2);
        assertTrue("The card c2 has been placed: ", t.getColumnGolds().size()==3);
    }
}
