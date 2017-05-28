package pl.edu.pwr.drozd.movieapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie_details.*

class DetailsFragment(val movie: Movie) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initializeInfo(movie)
    }

    private fun initializeInfo(movie: Movie?) {
        if (movie != null) {
            with(movie) {
                movie_title.text = title
                movie_description.text = description
            }
        }
    }
    companion object {
        val TAG = "DetailsFragment"
    }
}

