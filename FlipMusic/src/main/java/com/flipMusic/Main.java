package com.flipMusic;

import com.flipMusic.playlist.Playlist;
import com.flipMusic.playlist.Visibility;
import com.flipMusic.playlist.dao.PlaylistDb;
import com.flipMusic.playlist.service.PlaylistService;
import com.flipMusic.recommendationSystem.Recommendation;
import com.flipMusic.song.Song;
import com.flipMusic.song.dao.SongDb;
import com.flipMusic.user.User;
import com.flipMusic.user.dao.UserDb;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("song1", "AB", "Folk", 60);
        Song song2 = new Song("song2", "DEF", "Rock", 70);
        Song song3 = new Song("song3", "AB", "Country", 55);
        Song song4 = new Song("song4", "XYZ", "Rock", 60);
        Song song5 = new Song("song5", "XYZ", "Rock", 75);
        Song song6 = new Song("song6", "AB", "Country", 60);
        Song song7 = new Song("song7", "DEF", "Indie", 55);
        Song song8 = new Song("song8", "AB", "Folk", 60);

        SongDb songDb = SongDb.getInstance();
        /**
         * Adding all Songs to in memory SongDb database
         */
        songDb.addSong(song1);
        songDb.addSong(song2);
        songDb.addSong(song3);
        songDb.addSong(song4);
        songDb.addSong(song5);
        songDb.addSong(song6);
        songDb.addSong(song7);
        songDb.addSong(song8);

        User user1 = new User("user1");
        User user2 = new User("user2");

        UserDb userDb = UserDb.getInstance();
        /**
         * Adding all users to in memory UserDb database
         */
        userDb.addUser(user1);
        userDb.addUser(user2);

        PlaylistService playlistService = new PlaylistService();
        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        playlistService.createPlaylist(user1, Visibility.Private, "playlist1", songs);

        List<Song> songs1 = new ArrayList<>();
        songs1.add(song4);
        songs1.add(song5);
        songs1.add(song6);
        playlistService.createPlaylist(user2, Visibility.Public, "playlist2", songs1);

        List<Song> songs2 = new ArrayList<>();
        songs2.add(song7);
        playlistService.createPlaylist(user2, Visibility.Private, "playlist3", songs2);

        playlistService.addSongToPlaylist("user1", "playlist1", song4);

        System.out.println();
        System.out.println("showPlaylist(\"user1\",\"playlist1\")");
        playlistService.showPlaylist("user1","playlist1");

        System.out.println();
        System.out.println("recommendSong(user1)");
        Recommendation recommendation = new Recommendation();
        List<Song> songs3 = recommendation.recommendSong(user1);

        for(Song song: songs3) {
            System.out.println(song.getName());
        }

    }
}