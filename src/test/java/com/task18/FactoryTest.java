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

}