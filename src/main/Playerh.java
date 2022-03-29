package main;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Playerh extends Player {

    public Playerh(String n, ArrayList<Card> c){
        //PRE:
        //POS: It is created a player human with the string n like name and ArrayList like hand of cards.
        super(n,c);
    }

    public Playerh(){
        //PRE:
        //POS: It is created a player human with a name ordered on the screen and initialized arrayList
        super();
    }

    public void playCard(Table t){
        //PRE: The table have to be created and initialized.
        //POS: Added to the table t the card that ordered on the screen.
        if (!this.canPlayer(t)){
            System.out.println("You can´t play any of your cards. \n");
        }
        else{
            System.out.println("The table has the cards: "+ '\n' +t.showTable());
            System.out.println("Your deck is: "+ '\n' +this.showPlayer());
            System.out.println("Choose the card that you´d play");
            System.out.println("Write the suit of the card that you´s chosen: ");
            Scanner entrada=new Scanner(System.in);
            String s=entrada.nextLine();
            s.toLowerCase(Locale.ROOT);
            System.out.println("Write the number of the card that you´s chosen: ");
            Scanner entrada1=new Scanner(System.in);
            int n=entrada1.nextInt();
            Card c=new Card(n,s);
            if (t.canPlay(c)){
                t.putCard(c);
                this.cards.remove(c);
            }
            else{
                System.out.println("That card can´t be played, choose another \n");
                this.playCard(t);
            }
        }

    }

}

