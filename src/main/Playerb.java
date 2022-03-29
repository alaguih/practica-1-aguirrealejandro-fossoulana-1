package main;

import java.util.ArrayList;

public class Playerb extends Player{

    public Playerb(String n, ArrayList<Card> c){
        super(n,c);
    }

    public Playerb(){
        super();
    }

    public void playCard(Table t){
        //PRE: The table have to be created and initialized.
        //POS: Added to the table t the card that can be playable.
        if (!this.canPlayer(t)){
            System.out.println("You can´t play any of your cards.");
        }
        else{
            int i=0;
            while(i<this.hand().size()){
                if (t.canPlay(this.hand().get(i))){
                    t.putCard(this.hand().get(i));
                    System.out.println("Put card " + this.getName());
                    this.cards.remove(i);
                    i=this.hand().size();
                }
                i++;
            }
        }
    }


}
