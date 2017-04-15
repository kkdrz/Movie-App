package pl.edu.pwr.drozd.movieapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //swipe w prawo usuwa
    //long click wyswietla image oka w prawym dolnym, za kazdym razem bez znaczenia czy parzysty element listy
    //click przenosi do activity z infomracjami o filmie, na constraint_layout'cie
    //image, na nim tytuł, pod tym ocena i gwiazdki, potem opis
    //usuniecie, oczko i gwiazdki pamieta do zamkniecia aplikacji

    val movieList: MutableList<Movie> = prepareMovieData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(recycler_view) {
            adapter = MoviesAdapter(context, movieList)
            layoutManager = LinearLayoutManager(applicationContext)
        }
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
}


