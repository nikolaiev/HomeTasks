package com.task16;

import com.task16.util.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by vlad on 05.03.17.
 */
public class Field {
    /*ships list*/
    private List<Ship> ships = new ArrayList<>();

    /*field owner*/
    private Player player;

    /*max ship length*/
    private final int MAX_SHIP_LENGTH=4;

    /*field's cells matrix*/
    private Cell[][] cells;

    /*matrix side size*/
    public static final int SIZE=10;


    //initialize cells before constructor
    {

        cells=new Cell[SIZE][SIZE];
        //initialize cells
        for(int i=0;i<SIZE;i++){
            for (int j=0;j<SIZE;j++){
                cells[i][j]=new Cell();
            }
        }
    }

    /**
     * Constructor
     * @param player field owner
     */
    public Field(Player player) {
        this.player=player;
    }

    /*make shot into the cell*/
    public boolean killCell(int x,int y){
        return cells[x][y].kill();
    }

    /**
     * Initialize ships on the field
     */
    public void initShips() {
        for(int i=0;i<MAX_SHIP_LENGTH;i++){
            for(int j=i+1;j>0;j--) {

                int shipLength = MAX_SHIP_LENGTH - i;

                /*flag of random place availability to place the ship*/
                boolean isAllowed = false;

                /*until ship is not placed*/
                while (!isAllowed) {

                    int randomX = ThreadLocalRandom.current().nextInt(0, 9 + 1);
                    int randomY = ThreadLocalRandom.current().nextInt(0, 9 + 1);
                    /*horizontal or vertical state of ship*/
                    int direction = ThreadLocalRandom.current().nextInt(0, 1 + 1);

                    /*horizontal*/
                    if (direction == 0) {
                        if (randomX + shipLength < SIZE) {
                            isAllowed=addShipIfPossible(new Point(randomX, randomY),
                                    new Point(randomX + shipLength, randomY));
                        } else {
                            isAllowed=addShipIfPossible(new Point(randomX - shipLength, randomY),
                                    new Point(randomX, randomY));
                        }
                        continue;
                    }
                    //else

                    /*vertical*/
                    if (randomY + shipLength < SIZE) {
                        isAllowed=addShipIfPossible(new Point(randomX, randomY),
                                new Point(randomX, randomY + shipLength));
                    } else {
                        isAllowed=addShipIfPossible(new Point(randomX, randomY - shipLength),
                                new Point(randomX, randomY));
                    }
                }
            }
        }
    }

    /**
     * Observer method
     * checks if all ships are destroyed
     * called by destroyed ship
     */
    public void shipDestroyed() {
        for(Ship ship:ships){
            if(!ship.isShipDestroyed()){
                return;
            }
        }
        //say player that he has lost!
        player.loseGame();
    }

    /**
     * Draw field with ships showed
     */
    public void drawOpenField(){
        System.out.print("    "+ Colors.ANSI_BLUE);

        for(int i=0;i<SIZE;i++){
            System.out.print(" " + i+" ");
        }

        System.out.print("\n    ");

        for(int i=0;i<SIZE;i++){
            System.out.print(" " + '_' + " ");
        }
        System.out.println();

        //main data
        for(int x=0;x<SIZE;x++){
            System.out.print(x+ " | ");
            for(int y=0;y<SIZE;y++){

                Cell cell=cells[x][y];

                //check cell belongs to ship
                if(cell.isInShip()){
                        System.out.print(Colors.ANSI_PURPLE+" X ");
                }
                //check cell does not belong to ship
                else
                {
                    System.out.print(Colors.ANSI_GREEN+" O ");
                }

            }//for
            System.out.println(Colors.ANSI_BLUE+" |");
        }//for

        System.out.println();
        System.out.println();
    }

    /**
     * Draw field
     */
    public void drawFiled(){
        System.out.print("    "+Colors.ANSI_BLUE);

        for(int i=0;i<SIZE;i++){
            System.out.print(" " + i+" ");
        }

        System.out.print("\n    ");

        for(int i=0;i<SIZE;i++){
            System.out.print(" " + '_' + " ");
        }

        System.out.println();

        for(int x=0;x<SIZE;x++){
            System.out.print(x+ " | ");
            for(int y=0;y<SIZE;y++){

                Cell cell=cells[x][y];

                //check cell is shot
                if(cell.isShot()){
                    //check cell belongs to ship
                    if(cell.isInShip()){
                        //check shpit is swimming
                        if(cell.isShipDestroyed())
                            System.out.print(Colors.ANSI_RED+" X ");
                        else
                            System.out.print(Colors.ANSI_PURPLE+" X ");
                    }
                    //check cell does not belong to ship
                    else
                    {
                        System.out.print(Colors.ANSI_GREEN+" X ");
                    }
                }
                //cell is not shot
                else {
                    System.out.print(Colors.ANSI_RESET+" O ");
                }

            }//for
            System.out.println(Colors.ANSI_BLUE+" |");
        }//for

        System.out.println();
        System.out.println();

    }//drawField function

    /**
     *  Checks if it's possible to place ship on wanted place
     * @param begin Start cell of ship
     * @param end End cell of ship
     * @return true - if place is free
     */
    private boolean checkIfShipIsPossible(Point begin,Point end){

        if(begin.x!=end.x){
            final int Y=begin.y;

            final int X_MIN=
                    begin.x-1>-1 ?
                        begin.x-1
                        :0;

            final int X_MAX=
                    end.x+1<SIZE ?
                        end.x+1
                        :SIZE-1;

            final int Y_MAX=
                    Y+1<SIZE?
                            Y+1
                            :SIZE-1;

            final int Y_MIN=
                    Y-1>-1?
                            Y-1
                            :0;

            for(int i=X_MIN;i<X_MAX;i++) {
                if(cells[i][Y_MAX].isInShip() || cells[i][Y_MIN].isInShip() || cells[i][Y].isInShip()){
                    return false;
                }
            }
            return true;
        }
        //else
        /*begin.y != end.y*/
        final int X=begin.x;

        final int Y_MIN=
                begin.y-1>-1?
                        begin.y-1
                        :0;

        final int Y_MAX=
                end.y+1<SIZE?
                        end.y+1
                        :SIZE-1;

        final int X_MAX=
                X+1<SIZE?
                        X+1
                        :SIZE-1;

        final int X_MIN=
                X-1>-1?
                        X-1
                        :0;

        for(int i=Y_MIN;i<Y_MAX;i++) {
            if(cells[X_MAX][i].isInShip() || cells[X_MIN][i].isInShip() || cells[X][i].isInShip()){
                return false;
            }
        }
        return true;

    }

    /**
     *  Try to place ship on wanted position
     * @param begin Start cell of ship
     * @param end End cell of ship
     * @return true - if ship was placed
     */
    private boolean addShipIfPossible(Point begin,Point end){
        /*check if place is free*/
        boolean isAllowed =checkIfShipIsPossible(begin,end);

        if(isAllowed) {
            addShip(begin, end);
            return true;
        }
        //else
        return false;

    }

    /**
     *Adds ship to field's ship list
     * @param begin Start cell of ship
     * @param end End cell of ship
     */
    private void addShip(Point begin,Point end){
        Ship ship=new Ship(this);

        if(begin.x!=end.x){
            int y=begin.y;
            for(int i=begin.x;i<end.x;i++) {

                Cell cell = cells[i][y];
                cell.setShip(ship);
                ship.addCell(cells[i][y]);
            }
        }else {
            int x=begin.x;
            for(int i=begin.y;i<end.y;i++) {
                Cell cell = cells[x][i];
                cell.setShip(ship);
                ship.addCell(cells[x][i]);
            }
        }
        ships.add(ship);
    }

    /**
     * Static class
     * Represents Point (x,y) position of cell in game field
     */
    private static class Point{

        int x;
        int y;
        public  Point(int x,int y){
            this.x=x;
            this.y=y;
        }

    }
}
