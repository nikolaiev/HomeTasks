package com.task16;

import java.io.IOException;

/**
 * Created by vlad on 05.03.17.
 */
public class Game {
    /*create players*/
    Player player1=new Player("FIRST Player");
    Player player2=new Player("SECOND Player");

    /**
     * Game initialization method
     * @throws IOException can be thrown on user console input
     */
    public void start() throws IOException {
        /*init players field*/
        player1.initField();
        player2.initField();

        /*set opponent's field for ecah player*/
        player1.setOppField(player2.getField());
        player2.setOppField(player1.getField());

        /*game process*/
        while(true){

            while(player1.makeMove()) {
                System.out.println("Aimed!!!");
            /*check if P1 has destroyed all opponent's ships*/
                if (player2.isDestroyed()) {
                    System.out.println("Player 1 has won!");
                    return;
                }
            }

            while(player2.makeMove()) {
                System.out.println("Aimed!!!");

                if (player2.isDestroyed()) {
                    System.out.println("Player 2 has won!");
                    return;
                }
            }
        }
    }

    public static void main(String ... args) throws IOException {
        Game game=new Game();
        game.start();
    }
}
