package pl.edu.pwr.drozd.movieapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list_row.view.*

class MoviesAdapter(val moviesList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindMovie(moviesList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = moviesList.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindMovie(movie: Movie) {
            with(movie) {
                Glide.with(itemView.context).load(URL).into(itemView.movie_image)
                itemView.movie_title.text = title
                itemView.movie_genre.text = genre
                itemView.movie_year.text = year
            }
        }
    }

}