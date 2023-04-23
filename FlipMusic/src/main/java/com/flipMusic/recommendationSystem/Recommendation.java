package com.flipMusic.recommendationSystem;

import com.flipMusic.playlist.Playlist;
import com.flipMusic.playlist.dao.PlaylistDb;
import com.flipMusic.song.Song;
import com.flipMusic.song.dao.SongDb;
import com.flipMusic.user.User;
import com.flipMusic.user.dao.UserDb;

import java.util.*;

public class Recommendation {
    private UserDb userDb = UserDb.getInstance();
    private PlaylistDb playlistDb = PlaylistDb.getInstance();
    private SongDb songDb = SongDb.getInstance();

    public List<Song> recommendSong(User user) {
        List<Playlist> playlists = playlistDb.getPlaylists();
        List<Playlist> playlistsOfUser = new ArrayList<>();

        HashMap<String, Song> userSongs = new HashMap<>();
        HashMap<String, Integer> genre = new HashMap<>();
        HashMap<String, Integer> singer = new HashMap<>();
        HashMap<Integer, Integer> tempos = new HashMap<>();


        for(Playlist playlist: playlists) {
            if(playlist.getUser() == user) {
                // get the playlist of user
                playlistsOfUser.add(playlist);
                // get all the songs of a playlist
                List<Song> songs1 = playlist.getSongs();
                for(Song song: songs1) {
                    // put all the songs in a hashmap->userSongs<songName, Song>
                    userSongs.put(song.getName(), song);
                    if (genre.containsKey(song.getGenre())) {
                        int count = genre.get(song.getGenre());
                        genre.put(song.getGenre(), count + 1);
                    } else {
                        genre.put(song.getGenre(), 1);
                    }


                    if (singer.containsKey(song.getSinger())) {
                        int count = singer.get(song.getSinger());
                        singer.put(song.getSinger(), count + 1);
                    } else {
                        singer.put(song.getSinger(), 1);
                    }

                    if (tempos.containsKey(song.getTemp())) {
                        int count = tempos.get(song.getTemp());
                        tempos.put(song.getTemp(), count + 1);
                    } else {
                        tempos.put(song.getTemp(), 1);
                    }
                }
            }
        }

        List<Song> songs = songDb.getSongs();
        List<Song> recommendedSongs = new ArrayList<>();

        Map<Long, Song> scoreSong = new TreeMap<>(Collections.reverseOrder());

        for (Song song: songs) {
            if (userSongs.containsKey(song.getName())) continue; // not recommend the song which is already present in the playlist of a user
            for (Map.Entry<String, Song> entry: userSongs.entrySet()) {
                String songName = entry.getKey();
                Song songOfUser = entry.getValue();
                // if all the attribute of song is matching then it comes in to the recommend list
                if(songOfUser.getGenre() == song.getGenre() && song.getSinger() == songOfUser.getSinger() && song.getTemp() == songOfUser.getTemp()) {
                    recommendedSongs.add(song);
                }
            }
            /**
             * If there is a conflict, give preference to that song  which has the maximum  sum of  count of the number of songs in each category  in existing user playlists ,  with weightage for categories like this
             * Tempo: 1, Singer : 2, Genre: 3
             * So in case we have two songs: S1 and S2
             *  score of song would be calculated as S1 =
             *    3 * number of songs in user playlists having same genre
             *  + 2 * number of songs in user playlists having the same Singer
             *  + number of songs in user playlists having the same tempo.
             * Based on this score, which song has the highest score will come at the top.
             */
            if(!recommendedSongs.isEmpty() && recommendedSongs.get(recommendedSongs.size()-1) == song) continue; // if the song is already added into the recommend list then skip it.

            int genreCount = 0;
            if (genre.containsKey(song.getGenre())) {
                genreCount = genre.get(song.getGenre());
            }
            int singerCount = 0;
            if (singer.containsKey(song.getSinger())) {
                singerCount = singer.get(song.getSinger());
            }
            int tempoCount = 0;
            if (tempos.containsKey(song.getTemp())) {
                tempoCount = tempos.get(song.getTemp());
            }
            long score = ((3*genreCount) + (2*singerCount) + (tempoCount));
            scoreSong.put(score, song);
        }

        for(Map.Entry<Long, Song> entry: scoreSong.entrySet()) {
            long score = entry.getKey();
            Song song = entry.getValue();
            if(score != 0) {
                recommendedSongs.add(song);
            }
        }

        return recommendedSongs;
    }
}
