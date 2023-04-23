package com.flipMusic.playlist;

import com.flipMusic.song.Song;
import com.flipMusic.user.User;

import java.util.List;


public class Playlist {
    private String name;
    private User user;
    private Visibility visibility;
    private List<Song> songs;

    public Playlist() {
    }

    public Playlist(User user, Visibility visibility, String name, List<Song> songs) {
        this.user = user;
        this.visibility = visibility;
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
