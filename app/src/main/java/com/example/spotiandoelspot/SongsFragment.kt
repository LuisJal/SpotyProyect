import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotiandoelspot.HomeFragment
import com.example.spotiandoelspot.R
import com.example.spotiandoelspot.SongAdapter
import com.example.tema12.PlaylistResponse

class SongsFragment : Fragment() {
    private lateinit var playlist: PlaylistResponse.Playlist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playlist = it.getSerializable("playlist") as PlaylistResponse.Playlist
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_songs, container, false)
        val arrow = view.findViewById<ImageView>(R.id.backArrow)
        val playlistNameTextView = view.findViewById<TextView>(R.id.playlistName)
        val playlistName = playlist.nameOfSong
        playlistNameTextView.text=playlistName



        arrow.setOnClickListener{
            val searchFragment = SearchFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainCointainer ,searchFragment)
                .commit()
        }

        // Configurar el RecyclerView y el adaptador
        val recyclerViewSongs: RecyclerView = view.findViewById(R.id.recyclerViewSongs)
        val songsAdapter = SongAdapter(playlist.songs)

        val layoutManager = LinearLayoutManager(context)
        recyclerViewSongs.layoutManager = layoutManager

        recyclerViewSongs.adapter = songsAdapter

        return view
    }




}
