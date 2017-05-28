package pl.edu.pwr.drozd.movieapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment(val activityContext: Context, val movieList: MutableList<Movie>, val supportFragmentManager: FragmentManager) : Fragment() {

    val itemTouchHelper: ItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
            (recycler_view.adapter as MoviesAdapter).onItemRemoved(viewHolder, recycler_view)
        }

        override fun onMove(rV: RecyclerView?, vH: RecyclerView.ViewHolder?, t: RecyclerView.ViewHolder?) = false
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        with(recycler_view) {
            adapter = MoviesAdapter(activityContext, movieList, supportFragmentManager)
            layoutManager = LinearLayoutManager(activityContext)
        }
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    interface onMovieClicked {
        fun showMovieDetails(movie: Movie)
    }

}