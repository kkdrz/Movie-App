package pl.edu.pwr.drozd.movieapp.adapters


import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list_row_image_left.view.*
import pl.edu.pwr.drozd.movieapp.ContainerActivity
import pl.edu.pwr.drozd.movieapp.R
import pl.edu.pwr.drozd.movieapp.data.Movie


class MoviesAdapter(val context: Context, var moviesList: MutableList<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder?.itemViewType) {
            0 -> (holder as ViewHolderLeft).bindMovie(moviesList[position])
            else -> (holder as ViewHolderRight).bindMovie(moviesList[position])
        }

        with(holder.itemView) {
            setOnClickListener {
                context.startActivity(Intent(context, ContainerActivity::class.java)
                        .putExtra(SELECTED_MOVIE, holder.adapterPosition))
            }
            setOnLongClickListener {
                moviesList[position].watched = eye_img.visibility != RelativeLayout.VISIBLE
                notifyItemChanged(position)
                true
            }
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
        val SELECTED_MOVIE = "S_MOVIE"

        fun bindMovie(itemView: View, movie: Movie) {
            with(movie) {
                Glide.with(itemView.context).load(URL)
                        .placeholder(R.drawable.movie_placeholder)
                        .into(itemView.movie_image)

                itemView.movie_title.text = title
                itemView.movie_genre.text = genre
                itemView.movie_year.text = year

                if (watched)
                    itemView.eye_img.visibility = RecyclerView.VISIBLE
                else
                    itemView.eye_img.visibility = RecyclerView.INVISIBLE
            }
        }

    }

    fun onItemRemoved(viewHolder: RecyclerView.ViewHolder?, recycler_view: RecyclerView) {
        val position = viewHolder?.adapterPosition

        if (position != null) {
            val removedMovie = moviesList[position]
            moviesList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, moviesList.size - position - 1)

            Snackbar.make(recycler_view, R.string.movie_removed, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo, {
                        moviesList.add(position, removedMovie)
                        notifyItemInserted(position)
                        recycler_view.scrollToPosition(position)
                        notifyItemRangeChanged(position, moviesList.size - position - 1)
                    }).show()
        }
    }
}


