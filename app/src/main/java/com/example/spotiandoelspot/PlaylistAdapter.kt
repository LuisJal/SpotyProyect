import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spotiandoelspot.R
import com.example.tema12.PlaylistResponse.Playlist
import com.squareup.picasso.Picasso

class PlaylistAdapter(private val playlists: List<Playlist>) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private var playlistClickListener: OnPlaylistClickListener? = null

    fun setOnPlaylistClickListener(listener: OnPlaylistClickListener) {
        playlistClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.bind(playlist)
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playlistImage: ImageView = itemView.findViewById(R.id.playlistImage)
        private val playlistTitle: TextView = itemView.findViewById(R.id.playlistTitle)
        private val playlistFollowers: TextView = itemView.findViewById(R.id.playlistFollowers)

        init {
            itemView.setOnClickListener {
                val playlist = playlists[adapterPosition]
                playlistClickListener?.onPlaylistClick(playlist)
            }
        }

        fun bind(playlist: Playlist) {
            playlistTitle.text = playlist.nameOfSong
            playlistFollowers.text = "Followers: ${playlist.numberOfFollowers}"
            Picasso.get()
                .load(playlist.dummyImageUrl)
                .into(playlistImage)
        }
    }

    interface OnPlaylistClickListener {
        fun onPlaylistClick(playlist: Playlist)
    }
}
