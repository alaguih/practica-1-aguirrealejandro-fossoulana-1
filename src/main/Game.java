package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game{
    private Deck deck;
    private Table table;
    private ArrayList<Player> players;
    private int turn;
    private String winner;

    public Game(){
        //PRE:
        //POS: initialized the deck,the table and the array of players with the amount of bots and human players that you choose.
        this.players=new ArrayList<Player>();
        this.deck=new Deck();
        this.table=new Table();
        System.out.println("How many human players are going to play: ");
        Scanner s1=new Scanner(System.in);
        int i1=s1.nextInt();
        while (i1>0){
            this.players.add(new Playerh());
            i1--;
        }
        System.out.println("How many bot players are going to play: ");
        Scanner s2=new Scanner(System.in);
        int i2=s2.nextInt();
        while (i2>0){
            this.players.add(new Playerb());
            i2--;
        }
        this.turn=0;
        this.winner="no one";
    }

    public void startGame(){
        //PRE: The game has to be initialized.
        //POS: Randomized the array of players.
        int a=this.players.size();
        int j=0;
        Random r = new Random();
        while (j<40){
            int i1 = r.nextInt(a);
            int i2 = r.nextInt(a);
            Player p=this.players.get(i1);
            this.players.set(i1,this.players.get(i2));
            this.players.set(i2,p);
            j++;
        }
    }

    public void dealCards(){
        //PRE: The game has to be initialized.
        //POS: The deck will be shuffled and It will deal 10 card for each player.
        this.deck.shuffle();
        int i=0;
        int j=0;
        while(i<this.players.size()){
            while (j<10){
                this.players.get(i).getCard(this.deck.getCard());
                j++;
            }
            j=0;
            i++;
        }
    }

    public void makePlay(){
        //PRE: The game has to be initialized.
        //POS: Will be simulated a turn of the game "Cinquillo".
        boolean g = false;
        int i = 0;
        int n = 0;
        if(this.turn==0){
            while(i<this.numPlayers() && !g){
                if(this.players.get(i).playInitialCard(this.table)){
                    g = true;
                }
                i++;
            }
        }
        if(this.hasFinish()){
            System.out.println("The game has finished");
        }
        else{
            if(g){
                 n = i;
            }
            else{
                n = this.turn % this.players.size();
            }
            if (this.players.get(n).canPlayer(this.table)){
                this.players.get(n).playCard(this.table);
                if (this.players.get(n).finish()) {
                    this.winner = this.players.get(n).getName();
                    System.out.println(this.players.get(n).getName() + " has won");
                    System.out.println(finalResult());
                }
            }
            else{
                System.out.println("The player: " + this.players.get(n).getName() + " can´t play this turn. "+"("+this.turn+")");
                if(!this.deck.isEmpty()){
                    System.out.println(this.players.get(n).getName() + " steal a card. \n");
                    this.players.get(n).getCard(this.deck.getCard());
                }
            }
            this.turn++;
        }
    }

    public boolean hasFinish(){
        //PRE: The game has to be initialized.
        //POS: Return true if the game has finished and false otherwise.
        int i=0;
        while(i<this.players.size()){
            if(this.players.get(i).finish()){
                return true;
            }
            i++;
        }
        return false;
    }

    public String winner(){
        //PRE: The game has to be initialized.
        //POS: Return the name of the winner if there is one and no one if there isn´t.
        return "\nThe winner is: " + this.winner;
    }

    public String finalResult(){
        //PRE: The game has to be initialized.
        //POS: Return the final result of the game.
        int i=0;
        int sum = 0;
        int win = 0;
        String w = "";
        int sec = 0;
        String seg = "";
        int ter = 0;
        String t = "";
        String s="";
        while(i<this.players.size()) {
            for (int j = 0; j < this.players.get(i).cards.size(); j++) {
                sum = sum + this.players.get(i).cards.get(j).getNumCard();
            }
            if (sum > win) {
                t = seg;
                ter = sec;
                seg = w;
                sec = win;
                w = this.players.get(i).getName();
                win = sum;
            }
            i++;
        }
        return "\nTHE PODIUM BE" + "\nFIRST PLACE: " + w + "\nSECOND PLACE: " + seg + "\nTHIRD PLACE: " + t;
    }

    public Player getPlayer(int i){
        //PRE: The game has to be initialized.
        //POS: Return the player on the position i.
        return this.players.get(i);
    }

    public int numPlayers(){
        //PRE:
        //POS: Return the number of players.
        return this.players.size();
    }

    public ArrayList<Player> getPlayers() {
        //PRE: The game has to be initialized.
        //POS: Return the arraylist of players.
        return players;
    }
}
