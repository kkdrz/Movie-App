package pl.edu.pwr.drozd.movieapp

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.container_activity.*
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
        if (savedInstanceState == null)
            initDetailsFragment(moviePosition)

    }

    private fun initDetailsFragment(moviePosition: Int) {
        val bundle = Bundle()
        bundle.putInt(DetailsFragment.MOVIE_POSITION, moviePosition)

        val detailsFragment = DetailsFragment()
        detailsFragment.arguments = bundle
        replaceFragment(R.id.container1, detailsFragment)
    }

    fun replaceFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun showImagesAndCastFragments() {
        prepareFrames()
        replaceFragment(R.id.container1, ImagesFragment())
        replaceFragment(R.id.container2, CastFragment())
    }

    private fun prepareFrames() {
        container1.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        container2.visibility = ViewGroup.VISIBLE

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            adjustContainersToImgAndCastHorizont()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            adjustContainersToImgAndCastVertical()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            super.onBackPressed()
        else
            adjustContainersToDetails()
        supportFragmentManager.popBackStack()
        supportFragmentManager.popBackStack()
    }

    fun adjustContainersToImgAndCastVertical() {
        fragments_container.orientation = LinearLayout.VERTICAL
        fragments_container.requestLayout()
        container1.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        container2.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        container1.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        container2.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        container2.visibility = ViewGroup.VISIBLE
    }

    fun adjustContainersToImgAndCastHorizont() {
        fragments_container.orientation = LinearLayout.HORIZONTAL
        fragments_container.requestLayout()
        container1.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        container2.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        container1.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        container2.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
        container2.visibility = ViewGroup.VISIBLE
    }

    fun adjustContainersToDetails() {
        container1.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        container1.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        container2.visibility = ViewGroup.GONE
    }
}