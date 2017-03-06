package com.task16;

import java.io.*;

/**
 * Created by vlad on 05.03.17.
 */
public class Player {
    private String name;                    //player name
    Field myField;                          //player field
    Field oppField;                         //opponent field
    private boolean isAllShipsDestroyed;    //flag shows is all player ships were sink

    /**
     * Constructor
     * @param name player name
     */
    public Player(String name) {
        this.name=name;
    }

    /**
     * Shows opp fields in the console
     */
    public void showFields(){
        System.out.println(name+ " opponent's field");
        oppField.drawFiled();
        oppField.drawOpenField();
    }

    /**
     * Getter for myField
     * @return myField
     */
    public Field getField() {
        return myField;
    }

    /**
     * Initialization field method
     */
    public void initField() {
        this.myField = new Field(this);
        /*init ships on current field*/
        myField.initShips();
    }

    /**
     * Setter for opp field
     * @param oppField opponent field obj
     */
    public void setOppField(Field oppField) {
        this.oppField = oppField;
    }

    /**
     * Shows are all user ships sink
     * @return isAllShipsDestroyed flag
     */
    public boolean isDestroyed() {
        return isAllShipsDestroyed;
    }

    /**
     * Observer method for player field object
     * Called by field object when all ships are destroyed
     */
    public void loseGame() {
        isAllShipsDestroyed=true;
    }

    /**
     * User move logic method
     * @return  true - if player shot some ship
     * @throws IOException can be thrown on user input
     */
    public boolean makeMove() throws IOException {
        /*shows fields available for player*/
        showFields();

        //inpt reader
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        //input validating while-loop
        while(true) {
            //values to read
            int x;
            int y;

            try {
                System.out.print("Write X : ");

                x = Integer.parseInt(reader.readLine());

                if (x > Field.SIZE - 1 || x < 0)
                    throw  new NumberFormatException();

                System.out.print("Write Y : ");

                y = Integer.parseInt(reader.readLine());

                if (y > Field.SIZE - 1 || y < 0)
                    throw  new NumberFormatException();

            } catch (NumberFormatException e) {
                System.out.println("Coordinate is wrong! Try Again!");
                continue;
            }

            /*make shot*/
            return oppField.killCell(x,y);
        }
    }
}
