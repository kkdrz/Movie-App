package pl.edu.pwr.drozd.movieapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list_row_image_left.view.*

class MoviesAdapter(val context: Context, val moviesList: List<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when(holder?.itemViewType) {
            0 -> (holder as ViewHolderLeft).bindMovie(moviesList[position])
            else -> (holder as ViewHolderRight).bindMovie(moviesList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val itemViewImageLeft: View = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_row_image_left, parent, false)
        val itemViewImageRight: View = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_row_image_right, parent, false)

        when (viewType) {
            0 -> return ViewHolderLeft(itemViewImageLeft, context)
            else -> return ViewHolderRight(itemViewImageRight, context)
        }
    }

    override fun getItemCount(): Int = moviesList.size

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    class ViewHolderLeft(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindMovie(movie: Movie) {
            MoviesAdapter.bindMovie(itemView, movie)
        }
    }

    class ViewHolderRight(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindMovie(movie: Movie) {
            MoviesAdapter.bindMovie(itemView, movie)
        }
    }

    companion object {
        fun bindMovie(itemView: View, movie: Movie) {
            with(movie) {
                Glide.with(itemView.context).load(URL)
                        .placeholder(R.drawable.movie_placeholder)
                        .into(itemView.movie_image)
                itemView.movie_title.text = title
                itemView.movie_genre.text = genre
                itemView.movie_year.text = year
            }
        }
    }


}