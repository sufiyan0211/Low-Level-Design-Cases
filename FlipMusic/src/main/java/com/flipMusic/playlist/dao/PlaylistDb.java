package com.flipMusic.playlist.dao;

import com.flipMusic.playlist.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistDb {
    private static List<Playlist> playlists;
    private static boolean initialized = false;
    private static PlaylistDb playlistDb;

    private PlaylistDb() {
        playlists = new ArrayList<>();
    }

    public static PlaylistDb getInstance() {
        if(initialized == true) return playlistDb;
        initialized = true;
        playlistDb = new PlaylistDb();
        return playlistDb;
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }


    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
