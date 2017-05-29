package pl.edu.pwr.drozd.movieapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import pl.edu.pwr.drozd.movieapp.adapters.MoviesAdapter
import pl.edu.pwr.drozd.movieapp.fragments.CastFragment
import pl.edu.pwr.drozd.movieapp.fragments.DetailsFragment
import pl.edu.pwr.drozd.movieapp.fragments.ImagesFragment


class ContainerActivity : AppCompatActivity(), DetailsFragment.OnInfoButtonClickedListener {

    var moviePosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)

        moviePosition = intent.extras.get(MoviesAdapter.SELECTED_MOVIE) as Int

        if (savedInstanceState == null) {
            showDetailsFragment()
        }
    }

    fun replaceFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun showImagesAndCastFragments() {
        supportFragmentManager.popBackStack()
        replaceFragment(R.id.container1, ImagesFragment())
        replaceFragment(R.id.container2, CastFragment())
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount < 2) {
            super.onBackPressed()
            finish()
        } else {
            supportFragmentManager.popBackStack()
            supportFragmentManager.popBackStack()
            showDetailsFragment()
        }
    }

    private fun showDetailsFragment() {
        val bundle = Bundle()
        bundle.putInt(DetailsFragment.MOVIE_POSITION, moviePosition)

        val detailsFragment = DetailsFragment()
        detailsFragment.arguments = bundle
        replaceFragment(R.id.fragments_container, detailsFragment)
    }

}