package pl.edu.pwr.drozd.movieapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import pl.edu.pwr.drozd.movieapp.adapters.MoviesAdapter
import pl.edu.pwr.drozd.movieapp.data.Movie


class MainActivity : AppCompatActivity() {

    val itemTouchHelper: ItemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                    (recycler_view.adapter as MoviesAdapter).onItemRemoved(viewHolder, recycler_view)
                }

                override fun onMove(rV: RecyclerView?, vH: RecyclerView.ViewHolder?, t: RecyclerView.ViewHolder?) = false
            })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(recycler_view) {
            adapter = MoviesAdapter(applicationContext, movies)
            layoutManager = LinearLayoutManager(applicationContext)
        }
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            super.onBackPressed()
        else
            supportFragmentManager.popBackStack()
    }

    companion object {
        val movies = prepareMovieData()
        private fun prepareMovieData(): MutableList<Movie> {
            return mutableListOf(Movie("Mad Max: Fury Road", "Action & Adventure", "2015", description = "Mietek, dzielnicowy z Dąbrowy Górniczej postanowił coś zmienić w mieszkaniu i wytapetować sobie duży pokój w swoim M-3. Jak postanowił tak zrobił. Po remoncie przyszedł do niego Staszek, sąsiad z góry: -Miecio, aleś fajnie sobie urządził pokoik, naprawdę mi się podoba, też sobie tak zrobię! Powiedz mi tylko ile kupiłeś rolek tapety? -Dwanaście Staszku. -To też wezmę dwanaście. Staszek poszedł do Castoramy, kupił dwanaście rolek tapety o gładkiej teksturze, w kolorze muślinowego turkusu, wrócił do mieszkania i rozpoczął tapetowanie. Po jakimś czasie, gdy już skończył, poszedł do Mietka: -No, Mieciu, powiem Ci, że skończyłem, ładnie to wygląda ale coś mi się nie zgadza. Mamy taki sam metraż, powiedziałeś, że kupiłeś 12 rolek, ja zrobiłem to samo tyle, że mi zostało jeszcze pięć. -No, mi też.", rating = 3.5F),
                    Movie("Inside Out", "Animation, Kids & Family", "2015", rating = 2.0F),
                    Movie("Inside Out", "Animation, Kids & Family", "2015", rating = 1.0F),
                    Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", rating = 9.0F),
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
}



