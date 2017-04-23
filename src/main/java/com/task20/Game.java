package com.task20;

import com.task20.figures.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Vlad on 08.03.2017.
 */
public class Game {
    List<Figure> figures;

    /**
     * Default constructor
     */
    public Game() {
        this.figures = new ArrayList<>();
    }

    /**
     * Adds figure to figure list
     * @param figure figure obj no add
     */
    public void addFigure(Figure figure){
        if(figure==null)
            return;
        figures.add(figure);
    }

    /**
     * Get random figure from figure list
     * @return  Figure object
     */
    public Figure getRandomFigure(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, figures.size()+ 1);
        return figures.get(randomNum);
    }
}
