//Clase carta
package main;

import java.util.Locale;
import java.util.Objects;

public class Card {
    private int num;
    private String suit;

    public Card(int n, String s){
        //PRE: Receive a number and a string
        //POS: It is created a card.
        this.num=n;
        this.suit=s.toLowerCase(Locale.ROOT);
    }

    public int getNumCard() {
        //PRE: The card has to be initialized.
        //POS: Return the number of the card.
        return this.num;
    }

    public String getSuitCard() {
        //PRE: The card has to be initialized.
        //POS: Return the suit of the card.
        return this.suit;
    }

    public String showCard(){
        //PRE: The card has to be initialized.
        //POS: Return a string with the number and the suit of the card.
        return "Number " + this.num + " suit " + this.suit;
    }

    public boolean equals(Object o) {
        //PRE: Receive a object initialized
        //POS: Return true if is equals to the "this" and false in other case.
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Card card = (Card) o;
        return num == card.num && Objects.equals(suit, card.suit);
    }
}

