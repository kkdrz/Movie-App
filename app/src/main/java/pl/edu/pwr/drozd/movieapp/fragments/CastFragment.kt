package pl.edu.pwr.drozd.movieapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cast_fragment.*
import pl.edu.pwr.drozd.movieapp.R
import pl.edu.pwr.drozd.movieapp.adapters.CastAdapter

class CastFragment : Fragment() {

    companion object {
        const val TAG = "ImagesFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.cast_fragment, container, false)
    }

    override fun onViewCreated(view: android.view.View?, savedInstanceState: android.os.Bundle?) {
        with(cast_fragment_recycler) {
            adapter = CastAdapter()
            layoutManager = LinearLayoutManager(context)
        }
    }
}
