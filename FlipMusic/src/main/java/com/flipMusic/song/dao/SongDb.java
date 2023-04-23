package com.flipMusic.song.dao;

import com.flipMusic.song.Song;

import java.util.ArrayList;
import java.util.List;

public class SongDb {
    private List<Song> songs;
    private static boolean initialized = false;
    private static SongDb songDb;

    private SongDb() {
        songs = new ArrayList<>();
    }

    public static SongDb getInstance() {
        if(initialized == true) return songDb;
        initialized = true;
        songDb = new SongDb();
        return songDb;
    }

    public void addSong(Song song) {
        songs.add(song);
    }


    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
