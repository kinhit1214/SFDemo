package com.example.sfdemo.ui.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sfdemo.R
import com.example.sfdemo.ui.main.model.FilmEntity

class AdapterFilms() : RecyclerView.Adapter<AdapterFilms.CatalogViewHolder>(){

    private var filmsData: List<FilmEntity> = listOf<FilmEntity>()

    fun setFilmsAdapter(data : List<FilmEntity>){
        filmsData = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.film_entity, parent, false)
        return CatalogViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.nameFilm?.setText(filmsData[position].nameFilm)
        holder.topFilm?.setText(filmsData[position].topFilm)
        holder.yearFilm?.setText(filmsData[position].yearFilm)
    }

    override fun getItemCount(): Int = filmsData.size

    class CatalogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imagFilm : ImageView? = null
        var nameFilm : TextView? = null
        var yearFilm : TextView? = null
        var topFilm : TextView? = null

        init{
            imagFilm = itemView.findViewById(R.id.film_image)
            nameFilm = itemView.findViewById(R.id.name_film)
            yearFilm = itemView.findViewById(R.id.yer_film)
            topFilm = itemView.findViewById(R.id.top_film)
        }
    }
}
