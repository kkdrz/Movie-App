package pl.edu.pwr.drozd.movieapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.details_fragment.view.*
import pl.edu.pwr.drozd.movieapp.R

class ImagesAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val imagesList = prepareImages()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ImagesAdapter.ImageViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.movie_image_row, parent, false), context)
    }

    class ImageViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindImage(image: Int) {
            Glide.with(context)
                    .load(R.drawable.img1)
                    .placeholder(R.drawable.img1)
                    .centerCrop()
                    .into(itemView.movie_image)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ImageViewHolder).bindImage(imagesList[position])
    }

    override fun getItemCount(): Int = imagesList.size

    fun prepareImages(): MutableList<Int> {
        return mutableListOf(R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1)
    }
}
