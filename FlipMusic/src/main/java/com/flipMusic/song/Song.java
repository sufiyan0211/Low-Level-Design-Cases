package com.flipMusic.song;

public class Song {
    private String name;
    private String singer;
    private String genre;
    private int temp;

    public Song() {
    }

    public Song(String name, String singer, String genre, int temp) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
