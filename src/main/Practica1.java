package main;

public class Practica1 {
    public static void main(String args[]){
        Game g=new Game();
        g.startGame();
        g.dealCards();
        while(!g.hasFinish()){
            g.makePlay() ;
        }
    }
}
