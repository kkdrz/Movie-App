package pl.edu.pwr.drozd.movieapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_cast_row.view.*
import pl.edu.pwr.drozd.movieapp.R
import pl.edu.pwr.drozd.movieapp.data.Actor


class CastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val actorList = prepareActors()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return CastAdapter.ActorViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.movie_cast_row, parent, false))
    }

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindActor(actor: Actor) {
            with(actor) {
                itemView.actor_name.text = name
                itemView.actor_lastname.text = lastname
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ActorViewHolder).bindActor(actorList[position])
    }

    override fun getItemCount(): Int = actorList.size

    fun prepareActors(): MutableList<Actor> {
        return mutableListOf<Actor>(Actor("Selena", "Gomez"),
                Actor("Brat", "Pit"),
                Actor("Rodrigo", "Sanczez"),
                Actor("Rajan", "Black"),
                Actor("Kriszna", "Ale"),
                Actor("Helena", "Wojcik"),
                Actor("Pawel", "Polak"))
    }
}

