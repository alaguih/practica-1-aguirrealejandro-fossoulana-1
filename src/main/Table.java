//Clase
package main;

import java.util.*;

public class Table {
    private Deque<Card> columnGolds;
    private Deque<Card> columnCups;
    private Deque<Card> columnSwords;
    private Deque<Card> columnClubs;

    public Table(){
        //PRE:
        //POST:Creates the 4 empty structures with capacity of 12.
        columnGolds = new ArrayDeque<>(12);
        columnCups = new ArrayDeque<>(12);
        columnSwords = new ArrayDeque<>(12);
        columnClubs = new ArrayDeque<>(12);
        List<Deque<Card>> suits = new ArrayList<>();
        suits.add(columnGolds);
        suits.add(columnCups);
        suits.add(columnSwords);
        suits.add(columnClubs);
    }

    public boolean canPlay(Card c){
        //PRE:The table and the Card c have to be created.
        //POST:It will be returned true if the card c can be placed and false otherwise.
        int n=c.getNumCard();
        String s=c.getSuitCard().toLowerCase(Locale.ROOT);
        if (n==5){
            return true;
        }
        switch (s){
            case "golds":
                if(!this.getColumnGolds().isEmpty()) {
                    if ((this.getColumnGolds().getFirst().getNumCard() == n - 1) || (this.getColumnGolds().getLast().getNumCard() == n + 1)) {
                        return true;
                    }
                }
                break;
            case "cups":
                if(!this.getColumnCups().isEmpty()) {
                    if ((this.getColumnCups().getFirst().getNumCard() == n - 1) || (this.getColumnCups().getLast().getNumCard() == n + 1)) {
                        return true;
                    }
                }
                break;
            case "swords":
                if(!this.getColumnSwords().isEmpty()) {
                    if ((this.getColumnSwords().getFirst().getNumCard() == n - 1) || (this.getColumnSwords().getLast().getNumCard() == n + 1)) {
                        return true;
                    }
                }
                break;
            case "clubs":
                if(!this.getColumnClubs().isEmpty()) {
                    if ((this.getColumnClubs().getFirst().getNumCard() == n - 1) || (this.getColumnClubs().getLast().getNumCard() == n + 1)) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public void putCard(Card c){
        //PRE: The card c and the Desk have to be created.
        //POST: It will be returned true if the card is putted on the desk and false otherwise.
        if (this.canPlay(c)){
            int n=c.getNumCard();
            String s=c.getSuitCard().toLowerCase(Locale.ROOT);
            switch (s){
                case "golds":
                    if (this.getColumnGolds().isEmpty()){
                        this.getColumnGolds().add(c);
                    }
                    else {
                        if (this.getColumnGolds().getFirst().getNumCard() == n - 1) {
                            this.getColumnGolds().addFirst(c);
                        }
                        else {
                            this.getColumnGolds().addLast(c);
                        }
                    }
                    break;
                case "swords":
                    if (this.getColumnSwords().isEmpty()){
                        this.getColumnSwords().add(c);
                    }
                    else{
                        if (this.getColumnSwords().getFirst().getNumCard()==n-1){
                            this.getColumnSwords().addFirst(c);
                        }
                        else {
                            this.getColumnSwords().addLast(c);
                        }
                    }
                    break;
                case "cups":
                    if (this.getColumnCups().isEmpty()){
                        this.getColumnCups().add(c);
                    }
                    else{
                        if (this.getColumnCups().getFirst().getNumCard()==n-1){
                            this.getColumnCups().addFirst(c);
                        }
                        else {
                            this.getColumnCups().addLast(c);
                        }
                    }
                    break;
                case "clubs":
                    if (this.getColumnClubs().isEmpty()){
                        this.getColumnClubs().add(c);
                    }
                    else{
                        if (this.getColumnClubs().getFirst().getNumCard()==n-1){
                            this.getColumnClubs().addFirst(c);
                        }
                        else {
                            this.getColumnClubs().addLast(c);
                        }
                    }
                    break;
            }
        }
        else{
            System.out.println("The card can´t be played");
        }

    }

    public String showTable(){
        //PRE: The table has to be created.
        //Post: It will be returned a String of the cards on the desk.
        String g="";
        String s="";
        String c1="";
        String c2="";
        if(this.getColumnGolds().isEmpty()){
            g = "The column of golds is empty";
        }
        else {
            g = "The column of golds has the cards: ";
            for (Card c : this.getColumnGolds()) {
                g = g + "\n" + c.showCard();
            }
        }
        if(this.getColumnSwords().isEmpty()){
            s = "The column of swords is empty";
        }
        else {
            s = "The column of swords has the cards: ";
            for (Card c : this.getColumnSwords()) {
                s = s + "\n" + c.showCard();
            }
        }
        if(this.getColumnCups().isEmpty()){
            c1 = "The column of cups is empty";
        }
        else {
            c1 = "The column of cups has the cards: ";
            for (Card c : this.getColumnCups()) {
                c1 = c1 + "\n" + c.showCard();
            }
        }
        if(this.getColumnClubs().isEmpty()){
            c2 = "The column of clubs is empty";
        }
        else {
            c2 = "The column of clubs has the cards: ";
            for (Card c : this.getColumnClubs()) {
                c2 = c2 + "\n" + c.showCard();
            }
        }
        return "\n" + g + "\n" + s + "\n" + c1 + "\n" + c2 + "\n";
    }

    public Deque<Card> getColumnGolds() {
        //PRE: The column of golds have to be initialized.
        //POS: Return the column of golds.
        return this.columnGolds;
    }

    public Deque<Card> getColumnCups() {
        //PRE: The column of cups have to be initialized.
        //POS: Return the column of cups.
        return this.columnCups;
    }

    public Deque<Card> getColumnSwords() {
        //PRE: The column of swords have to be initialized.
        //POS: Return the column of swords.
        return this.columnSwords;
    }

    public Deque<Card> getColumnClubs() {
        //PRE: The column of clubs have to be initialized.
        //POS: Return the column of clubs.
        return this.columnClubs;
    }







}

