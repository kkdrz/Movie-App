package pl.edu.pwr.drozd.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity(), MainFragment.onMovieClicked   {

    //long click wyswietla image oka w prawym dolnym, za kazdym razem bez znaczenia czy parzysty element listy
    //usuniecie, oczko i gwiazdki pamieta do zamkniecia aplikacji
    val movieList: MutableList<Movie> = prepareMovieData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayMainFragment()
    }

    private fun prepareMovieData(): MutableList<Movie> {
        return mutableListOf(Movie("Mad Max: Fury Road", "Action & Adventure", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"),
                Movie("Shaun the Sheep", "Animation", "2015"),
                Movie("The Martian", "Science Fiction & Fantasy", "2015"),
                Movie("Mission: Impossible Rogue Nation", "Action", "2015"),
                Movie("Up", "Animation", "2009"),
                Movie("Star Trek", "Science Fiction", "2009"),
                Movie("The LEGO Movie", "Animation", "2014"),
                Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"),
                Movie("Mad Max: Fury Road", "Action & Adventure", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"),
                Movie("Shaun the Sheep", "Animation", "2015"),
                Movie("The Martian", "Science Fiction & Fantasy", "2015"),
                Movie("Mission: Impossible Rogue Nation", "Action", "2015"),
                Movie("Up", "Animation", "2009"),
                Movie("Star Trek", "Science Fiction", "2009"),
                Movie("The LEGO Movie", "Animation", "2014"),
                Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"),
                Movie("Mad Max: Fury Road", "Action & Adventure", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"),
                Movie("Shaun the Sheep", "Animation", "2015"),
                Movie("The Martian", "Science Fiction & Fantasy", "2015"),
                Movie("Mission: Impossible Rogue Nation", "Action", "2015"),
                Movie("Up", "Animation", "2009"),
                Movie("Star Trek", "Science Fiction", "2009"),
                Movie("The LEGO Movie", "Animation", "2014"),
                Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014"))
    }

    fun displayMainFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.movie_details_fragment_placeholder, MainFragment(this, prepareMovieData(), supportFragmentManager))
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            super.onBackPressed()
        else
            supportFragmentManager.popBackStack()
    }

    override fun showMovieDetails(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}



