package main;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    private String name;
    protected ArrayList<Card> cards;

    public Player(){
        //PRE:
        //POS: It is created a player with a name ordered on the screen and initialized arrayList
        System.out.println("Write the name of the player: ");
        Scanner entrada=new Scanner(System.in);
        String s=entrada.nextLine();
        this.name=s;
        this.cards=new ArrayList<Card>();
    }

    public Player(String n, ArrayList<Card> c){
        //PRE:
        //POS: It is created a player with the string n like name and ArrayList like hand of cards.
        this.name=n;
        this.cards=c;
    }

    public boolean canPlayer(Table t){
        //PRE: The table have to be created and initialized.
        //POST: It will be returned true if the card c can be playable in the table and false otherwise.
        int i=0;
        while (i<this.cards.size()){
            if (t.canPlay(this.cards.get(i))){
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean haveCard(Card c){
        //PRE: The card have to be created and initialized.
        //POS: It will be returned true if the player have the card c and false otherwise.
        int i=0;
        while (i<this.cards.size()){
            if (this.cards.get(i)==c){
                return true;
            }
            i++;
        }
        return false;
    }

    public int cardsLeft(){
        //PRE:
        //POS: Return the number of remaining cards of the player.
        return this.cards.size();
    }

    public boolean finish(){
        //PRE:
        //POS: Return true if the card of the player is empty and false otherwise.
        return this.cards.isEmpty();
    }

    public String showPlayer(){
        //PRE:
        //POS: Returns a string with player data and cards.
        String s="Player: "+this.name;
        int i=0;
        while(i<this.cards.size()){
            s=s+ '\n' + this.cards.get(i).showCard();
            i++;
        }
        return s;
    }

    public void getCard(Card c){
        //PRE: The card have to be created and initialized.
        //POS: Added to the hand of card the card c.
        this.cards.add(c);
    }

    public ArrayList<Card> hand(){
        //PRE:
        //POS: Return the arraylist of the cards on the hand.
        return this.cards;
    }

    public String getName(){
        //PRE:
        //POS: Return the name of the player.
        return this.name;
    }

    public boolean playInitialCard(Table t){
        //PRE: The table have to be created and initialized.
        //POS: Return true if some player have the five of golds and they played and false in otherwise.
        Card c = new Card(5, "Golds");
        boolean b = false;
        for(int i=0;i<this.cards.size();i++){
            b = this.cards.get(i).equals(c);
            if(b){
                t.putCard(c);
                return this.cards.remove(c);
            }
        }
        return false;
    }

    public abstract void playCard(Table t);


}

