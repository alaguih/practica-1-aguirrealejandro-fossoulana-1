//Clase deck
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck{

    private ArrayList<Card> deck;

    private static int size = 48;

    public Deck(){
        //PRE:
        //POST: It is created an ordered deck of cards.
        int i=0;
        int j=1;
        this.deck = new ArrayList<Card>();
        while(j<=12){
            deck.add(new Card(j,"Golds"));
            j++;
            i++;
        }
        j=1;
        while(j<=12){
            deck.add(new Card(j,"Cups"));
            j++;
            i++;
        }
        j=1;
        while(j<=12){
            deck.add(new Card(j,"Swords"));
            j++;
            i++;
        }
        j=1;
        while(j<=12) {
            deck.add(new Card(j, "Clubs"));
            j++;
            i++;
        }
    }
    public void shuffle(){
        //PRE: The deck of cards has to be created.
        //POST: The deck of cards will be shuffled.
        Random r = new Random();
        int k=0;
        while (k<this.deck.size()){
            int i = r.nextInt(deck.size());
            int j = r.nextInt(deck.size());
            Card c= deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j,c);
            k++;
        }
    }
    public Card getCard(){
        //PRE: The deck of cards has to be created.
        //POST: It is returned the last card of the deck.
        if(!this.deck.isEmpty()){
            Card c = this.deck.get(deck.size()-1);
            this.deck.remove(deck.size()-1);
            return c;
        }
        else{
            return null;
        }

    }
    public int cardsLeft(){
        //PRE: The deck has to be created.
        //POST: It will be returned true id the deck is empty and false otherwise.
        return deck.size();
    }
    public void cut(int i){
        //PRE: The deck has to be created and i<=baraja.size().
        //POST: The deck will be cutted by the card i.
        List<Card> b1= deck.subList(i, deck.size());
        List<Card> b2= deck.subList(0,i);
        deck.clear();
        int j=0;
        while (j<i){
            deck.add(b2.get(j));
            j++;
        }
        while (j< deck.size()){
            deck.add(b1.get(j));
            j++;
        }
    }

    public int getNumCards() {
        //PRE: The deck has to be created and initialized.
        //POS: Returns the number of cards in the deck.
        return deck.size();
    }

    public boolean isEmpty(){
        //PRE: The deck has to be created and initialized.
        //POS: Returns true if the deck is empty and false otherwise.
        return this.deck.isEmpty();
    }


}
