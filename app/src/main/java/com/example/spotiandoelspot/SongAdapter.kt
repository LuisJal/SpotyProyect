package com.example.spotiandoelspot

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema12.PlaylistResponse
import com.google.android.material.snackbar.Snackbar

import com.squareup.picasso.Picasso
import kotlin.math.log

class SongAdapter(private val songs: List<PlaylistResponse.Playlist.Song>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.bind(song)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val songImage: ImageView = itemView.findViewById(R.id.songImage)
        private val songArtist: TextView = itemView.findViewById(R.id.songArtist)
        private val songName: TextView = itemView.findViewById(R.id.songName)
        private val favoriteIcon: ImageView = itemView.findViewById(R.id.favoriteIcon)

        fun bind(song: PlaylistResponse.Playlist.Song) {

            Log.i("Artista",song.artist)
            Log.i("nombre",song.name)

            Picasso.get()
                .load(song.url)
                .into(songImage)

            songArtist.text = song.artist
            songName.text = song.name

            favoriteIcon.setOnClickListener {
                // Cambiar el estado del favorito
                song.isFavorite = !song.isFavorite


                // Actualizar la imagen del icono de favorito
                val favoriteIconResId = if (song.isFavorite) {
                    R.drawable.baseline_favorite_24
                } else {
                    R.drawable.baseline_favorite_border_24
                }
                favoriteIcon.setImageResource(favoriteIconResId)

                // Mostrar el Snackbar con el título de la canción
                if(song.isFavorite){
                    val snackbarMessage = "Se ha añadido la canción ${song.name} a favoritos"
                    Snackbar.make(itemView, snackbarMessage, Snackbar.LENGTH_SHORT).show()

                }

            }

        }
    }
}
