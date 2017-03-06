package com.task18;

/**
 * Created by vlad on 06.03.17.
 */
public abstract class AbstractFactory {
    abstract Film getFilm(Language language,FilmType filmType,String title);
}
