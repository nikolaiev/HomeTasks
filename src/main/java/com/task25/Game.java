package com.task25;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Game {
    /*contains prev step*/
    private Memento memento;
    /*game field*/
    private Field field=new Field();

    /**
     * Empty constructor
     */
    public Game() {
        field.initDefaultField();
    }

    /**
     * Start the game
     */
    public void start(){
        Memento memento;
        int turnIndex=0;//0 - first player ; 1 - second player

        Memento m=field.saveState();
        while (true){
            CellMarkType cellMarkType=
                    turnIndex==0?
                            CellMarkType.CROSS
                            :CellMarkType.CIRCLE;
            System.out.println("make step "+ cellMarkType );

            if(!makeRandomStep(cellMarkType,m))
                turnIndex+=1;

            if(field.checkHasWon(cellMarkType)){
                System.out.println("Game is over");
                System.out.println(cellMarkType + " has won");
                return;
            }

            if(field.checkDraw()){
                System.out.println("DRAW");
                return;
            }
            turnIndex=(turnIndex+1)%2;
            m=field.saveState();
        }
    }

    /**
     * Make random step
     * @param cellMarkType cellMarkTypr
     * @param m Memento obj
     * @return  true if step is done ; false if state is recovered
     */
    private boolean makeRandomStep(CellMarkType cellMarkType,Memento m){
        boolean isMarked=false;

        int randStepCancel=ThreadLocalRandom.current().nextInt(0, 5 + 1);

        if(randStepCancel==5){
            field.restoreState(m);
            System.out.println("Restored State to last turn");

            return false;
        }

        while(true){
            int randX=ThreadLocalRandom.current().nextInt(0, 2 + 1);
            int randY=ThreadLocalRandom.current().nextInt(0, 2 + 1);



            if(field.getCellMark(randX,randY)==CellMarkType.EMPTY) {
                System.out.println(randX);
                System.out.println(randY);
                field.setCellMark(randX, randY, cellMarkType);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Game game=new Game();
        game.start();
    }
}
