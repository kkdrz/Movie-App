package pl.edu.pwr.drozd.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movie = intent.extras.get(MoviesAdapter.SELECTED_MOVIE) as Movie
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
}
