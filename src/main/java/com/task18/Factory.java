package com.task18;

import com.task19.FantasyTopic;

/**
 * Created by vlad on 06.03.17.
 */
public final class Factory  extends  AbstractFactory{
    private static Factory instance=new Factory();
    public static Factory getInstance(){return instance;}

    @Override
    public Film getFilm(Language language,FilmType filmType,String title) {
        return new Film(language,filmType,title);
    }
}
