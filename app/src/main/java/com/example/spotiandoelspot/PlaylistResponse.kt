package com.example.tema12


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlaylistResponse(
    val data: List<Playlist>,
    val pages: Int
) : Serializable {
    data class Playlist(
        @SerializedName("dummy_image_url")
        val dummyImageUrl: String,
        val id: Int,
        @SerializedName("name_of_song")
        val nameOfSong: String,
        @SerializedName("number_of_followers")
        val numberOfFollowers: Int,
        val songs: List<Song>
    ) : Serializable{
        data class Song(
            val artist: String,
            val name: String,
            val url: String,
            var isFavorite: Boolean = false
        ) : Serializable
    }
}