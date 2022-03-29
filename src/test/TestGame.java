package test;

import main.Deck;
import main.Game;
import main.Player;
import main.Table;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestGame {
    @Test
    public void testGame(){
        ArrayList<Player> players = new ArrayList<Player>();
        Deck deck = new Deck();
        Table t = new Table();
        Game g = new Game();
        g.startGame();
        assertTrue("The game have two player: ", g.getPlayers().size()==2);
    }
}
