package pl.edu.pwr.drozd.movieapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list_row.view.*

class MoviesAdapter(val context: Context, val moviesList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindMovie(moviesList[position])
        when (position % 2) {
            0 -> holder?.moveImageToLeft()
            else -> holder?.moveImageToRight()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent?.context).inflate(R.layout.movie_list_row, parent, false)
        return ViewHolder(itemView, context)
    }

    override fun getItemCount(): Int = moviesList.size


    class ViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindMovie(movie: Movie) {
            with(movie) {
                Glide.with(itemView.context).load(URL)
                        .placeholder(R.drawable.movie_placeholder)
                        .into(itemView.movie_image)
                itemView.movie_title.text = title
                itemView.movie_genre.text = genre
                itemView.movie_year.text = year
            }

        }

        fun moveImageToRight() {
            (itemView.movie_image.layoutParams as RelativeLayout.LayoutParams).apply {
                addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
                removeRule(RelativeLayout.ALIGN_PARENT_START)
                leftMargin = context.resources.getDimensionPixelOffset(R.dimen.movie_image_marginRightLeft)
                rightMargin = 0
            }

            (itemView.movie_info_layout.layoutParams as RelativeLayout.LayoutParams).apply {
                addRule(RelativeLayout.START_OF, R.id.movie_image)
                removeRule(RelativeLayout.END_OF)
            }
        }

        fun moveImageToLeft() {
            (itemView.movie_image.layoutParams as RelativeLayout.LayoutParams).apply {
                addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
                removeRule(RelativeLayout.ALIGN_PARENT_END)

                leftMargin = 0
                rightMargin = context.resources.getDimensionPixelOffset(R.dimen.movie_image_marginRightLeft)
            }

            (itemView.movie_info_layout.layoutParams as RelativeLayout.LayoutParams).apply {
                addRule(RelativeLayout.END_OF, R.id.movie_image)
                removeRule(RelativeLayout.START_OF)
            }
        }
    }

}