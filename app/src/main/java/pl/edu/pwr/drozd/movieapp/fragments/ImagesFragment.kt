package pl.edu.pwr.drozd.movieapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.images_fragment.*
import pl.edu.pwr.drozd.movieapp.R
import pl.edu.pwr.drozd.movieapp.adapters.ImagesAdapter


class ImagesFragment : Fragment()   {
    companion object {
        const val TAG = "ImagesFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.images_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        with(images_recycler) {
            adapter = ImagesAdapter(context)
            layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        }
    }
}