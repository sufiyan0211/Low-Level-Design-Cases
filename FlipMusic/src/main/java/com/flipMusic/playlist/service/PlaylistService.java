package com.flipMusic.playlist.service;

import com.flipMusic.playlist.Playlist;
import com.flipMusic.playlist.Visibility;
import com.flipMusic.playlist.dao.PlaylistDb;
import com.flipMusic.song.Song;
import com.flipMusic.user.User;
import com.flipMusic.user.dao.UserDb;

import java.util.ArrayList;
import java.util.List;

public class PlaylistService {
    // Eager Initialization
    private PlaylistDb playlistDb = PlaylistDb.getInstance();
    private UserDb userDb = UserDb.getInstance();

    public Playlist createPlaylist(User user, Visibility visibility, String playlistName, List<Song> songs) {
        Playlist playlist = new Playlist(user, visibility, playlistName, songs);
        List<Playlist> playlists = playlistDb.getPlaylists();
        playlists.add(playlist);
        playlistDb.setPlaylists(playlists);
        return playlist;
    }

    public Playlist findPlaylistByName(String playlistName) throws IllegalArgumentException{
        List<Playlist> playlists = playlistDb.getPlaylists();
        for (Playlist playlist : playlists) {
            if(playlist.getName() == playlistName) {
                return playlist;
            }
        }
        throw new IllegalArgumentException(String.format("Playlist - %s does not exist", playlistName));
    }

    public Playlist addSongToPlaylist(String userName, String playlistName, Song song) throws IllegalArgumentException{
        User user = userDb.getUserByName(userName);
        List<Song> songsList = new ArrayList<>();
        songsList.add(song);
        Playlist playlist;
        try {
            playlist = findPlaylistByName(playlistName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
        playlistDb.removePlaylist(playlist);
        List<Song> songs = playlist.getSongs();
        songs.add(song);
        playlist.setSongs(songs);
        playlist.setUser(user);
        playlistDb.addPlaylist(playlist);
        return playlist;
    }

    public Playlist showPlaylist(String userName, String playlistName) throws IllegalArgumentException{
        User user = userDb.getUserByName(userName);
        Playlist playlist = new Playlist();
        try {
            playlist = findPlaylistByName(playlistName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        if(playlist.getUser() == user) {
            System.out.println(String.format("Playlist Name: %s", playlist.getName()));
            System.out.println(String.format("User Name: %s", user.getName()));
            System.out.println(String.format("Available songs are: "));
            List<Song> songs = playlist.getSongs();
            for (Song song: songs) {
                System.out.println(song.getName());
            }
        }
        return playlist;
    }
}
