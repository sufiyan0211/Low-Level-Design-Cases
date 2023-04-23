Flip-Music Recommendation system
===


## Problem Definition:
<p>
Flipkart is coming up with a new music recommendation system called Flip-music.<br>
Create a flip-music recommendation system which suggests songs according to user taste.
</p>

## Features:
### Application has two major things :
* The songs, which are cataloged in the app’s data store. Songs can be described by attributes such as genre, tempo, singer.
* The people : Each person has a playlist of songs that they can choose to play from.

Design a system that recommends a set of songs from our music library to the user based on his preferences (matching genre / singer/ tempo) taking into account his current playlist.


Pick a song based on the following order:
First preference is the number of matching attributes with existing playlists of songs of the user.
If there is a conflict, give preference to that song  which has the maximum  sum of  count of the number of songs in each category  in existing user playlists ,  with weightage for categories like this
Tempo: 1, Singer : 2, Genre: 3
So in case we have two songs: S1 and S2
score of song would be calculated as S1 = 3*number of songs in user playlists having same genre + 2* number of songs in user playlists having the same Singer + number of songs in user playlists having the same tempo.
Based on this score, which song has the highest score will come at the top.
Show the recommended songs in a sorted order(Most matched one first, least matched in the last)
Requirements:
Add a new song to the data store.
Add a new user to the system.
Create a playlist for the user
Add songs to the user’s playlist
Display user’s playlist
Playlist can be private or public depending on the users choice
Recommend songs based on user preferences:
Public playlist will be visible to all.
Extend the system to let users add friends.
add_friend(“user1”, “user2”)
user1 and user2 can see each other’s playlist including private playlist as well.
Bonus question:
Recommend songs based on the user and his friends playlist.
Shuffle-play a playlist for the user, user should be able to go to the last played song.
Give the recommendations based on user preference like give_recommendations1({“tempo”: “60- 80”, “singer”:”arijitth” }), give_recommendations2({“tempo”: “60- 80”, “genre”:”melody” })
t

## Other Details:
* Do not use any database or NoSQL store, use in-memory store for now.
* Do not create any UI for the application.
* Code should be demo-able. Write a driver class for demo purpose, which will execute all the commands at one place in the code and test cases.
* Code should be extensible. Wherever applicable, use interfaces and contracts between different methods
* Work on the expected output first and then add good-to-have features of your own.
* Try to read the test cases from a file or console.



## Test Cases:
### (Test cases are defined for understanding feature requirements only. Please model it appropriately based on your service implementation)

### Assuming following songs exist in app store

* Song1 {name:“song1”, singer:“AB”, genre:”Folk”, tempo:60}
* Song2 {name:“song2”, singer:“DEF”, genre:”Rock”, tempo:70}
* Song3 {name:“song3”, singer:“AB”, genre:”Country”, tempo:55}
* Song4 {name:“song4”, singer:“XYZ”, genre:”Rock”, tempo:60}
* Song5 {name:“song5”, singer:“XYZ”, genre:”Rock”, tempo:75}
* Song6 {name:“song6”, singer:“AB”, genre:”Country”, tempo:60}
* Song7 {name:“song7”, singer:“DEF”, genre:”Indie”, tempo:55}

### Here are the sample test cases to run:

* add_song(name:“song8”, singer:“AB”, genre:”Folk”, tempo:60)
* add_user (name:“user1”)
* add_user (name:“user2”)
* create_playlist ( “user1”, private, ,“playlist1”, {“song1”, “song2”, “song3”})
* create_playlist ( “user2, public, ,“playlist2”, {“song4”, “song5”, “song6”})
* create_playlist ( “user2, private, ,“playlist3”, {“song7”})
* add_song_to_playlist (“user1”, “playlist1”, “song4”)
* show_playlist (“user1”, “playlist1” )
* view_other_user_playlist(“user1”,“user2”) // shows only playlist2
* add_friend(“user1”, “user2”)
* view_other_user_playlist(“user1”,“user2”)//shows playlist2 and playlist3 both.
* view_other_user_playlist(“user3”,“user2”)//shows playlist2
* recommend_songs(“user1”)// show recommended songs matching selection criteria.
  * Song 8 - matching all 3 attributes (singer, genre, tempo - all matching with song1)
  * Song 6 - matching two attributes (3x1+ 2x2+ 1x2) = 9
  * Song 5 - matching two attributes ( 3x2+ 2x1+ 1x0) = 8
  * Song 7 - Single matching attribute













