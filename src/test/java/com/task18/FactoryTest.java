package com.task18;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 06.03.17.
 */
public class FactoryTest {
    Factory factory=Factory.getInstance();
    @Test
    public void getInstance() throws Exception {
        assertNotNull(factory);
    }

    @Test
    public void getFilm() throws Exception {
        Film film=factory.getFilm(Language.ENG,FilmType.COMEDY,"Mister Bin!");
       assertNotNull(film);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilmLangNull() throws Exception {
        Film film=factory.getFilm(null,FilmType.COMEDY,"Mister Bin!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilmTypeNull() throws Exception {
        Film film=factory.getFilm(Language.ENG,null,"Mister Bin!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFilmTitleNull() throws Exception {
        Film film=factory.getFilm(Language.ENG,FilmType.COMEDY,null);
    }


}