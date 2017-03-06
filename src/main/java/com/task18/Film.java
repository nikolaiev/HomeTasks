package com.task18;

/**
 * Created by vlad on 06.03.17.
 */
public class Film {
    private Language language; //sound and subtitles language
    private String title;
    private FilmType filmType;

    public Film(Language language, FilmType filmType, String title) {

        this.language = language;
        this.title = title;
        this.filmType = filmType;
    }

    /*getters setters*/
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

}
