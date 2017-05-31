package pl.edu.pwr.drozd.movieapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.images_fragment.*
import pl.edu.pwr.drozd.movieapp.R
import pl.edu.pwr.drozd.movieapp.adapters.ImagesAdapter


class ImagesFragment : Fragment() {
    companion object {
        const val TAG = "ImagesFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.images_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        images_recycler.adapter = ImagesAdapter(context)
    }
}