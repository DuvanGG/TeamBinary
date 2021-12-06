package com.example.binaryteam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class SiteAdapter(
    private val mSite: ArrayList<Site>,
    private val context: Context,
    private val onClick: (Site) -> Unit
) : RecyclerView.Adapter<SiteAdapter.SiteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.site_display_layout, parent, false)
        return SiteViewHolder(view)
    }

    override fun onBindViewHolder(holderSite: SiteViewHolder, position: Int)
    {
        val site = mSite[position]
        holderSite.bind(site = site)
    }


    //Retorna la cantidad de elementos mi lista
    override fun getItemCount(): Int
    {
        return mSite.size
    }

    inner class SiteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private var nameLabel: TextView = itemView.findViewById(R.id.titulo)

        private var ratSiteBar: RatingBar = itemView.findViewById(R.id.ratBar)
        private var descripcion: TextView = itemView.findViewById(R.id.description)
        private var currentSite: Site? = null

        init {
            itemView.setOnClickListener {
                currentSite?.let {
                    onClick(it)
                }
            }
        }

        /* Bind Contact name and image. */
        fun bind(site: Site) {

            currentSite = site
            nameLabel.text = site.titulo
            ratSiteBar.rating = site.calificacion.toFloat()
            descripcion.text = site.descripcion




        }
    }
}
