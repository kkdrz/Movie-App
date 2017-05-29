package pl.edu.pwr.drozd.movieapp.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.details_fragment.*
import pl.edu.pwr.drozd.movieapp.MainActivity
import pl.edu.pwr.drozd.movieapp.R
import pl.edu.pwr.drozd.movieapp.data.Movie

class DetailsFragment : Fragment() {

    companion object {
        val TAG = "DetailsFragment"
        val MOVIE_POSITION = "movie_pos"
    }

    var moviePosition: Int = 0
    var listener: OnInfoButtonClickedListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnInfoButtonClickedListener)
            listener = context
        else throw ClassCastException("$context must implement DetailsFragment.OnInfoButtonListener")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviePosition = arguments.getInt(MOVIE_POSITION)
        initializeViewWithInfo(MainActivity.movies[moviePosition])

        movie_rating_bar.setOnRatingBarChangeListener { _, rating, _ ->
            MainActivity.movies[moviePosition].rating = rating
        }

        image_info.setOnClickListener {
            listener?.showImagesAndCastFragments()
        }

    }

    private fun initializeViewWithInfo(movie: Movie?) {
        if (movie != null) {
            with(movie) {
                movie_title.text = title
                movie_description.text = description
                movie_rating_bar.rating = rating
            }
        }
    }

    interface OnInfoButtonClickedListener {
        fun showImagesAndCastFragments()
    }

}

