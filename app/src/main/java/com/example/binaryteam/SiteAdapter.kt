package com.example.binaryteam

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SiteAdapter (private val sitesList: ArrayList<Site>

) : RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.site_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val site = sitesList[position]
        holder.bind(site)

    }

    override fun getItemCount(): Int {
        return sitesList.size

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var titleTextView: TextView = itemView.findViewById(R.id.siteTitle)
        private var descripcionTextView: TextView = itemView.findViewById(R.id.siteDescription)
        private var ubicacionTextView: TextView = itemView.findViewById(R.id.siteLocation)
        //private var imagenTextView: ImageView = itemView.findViewById(R.id.siteImage)
        //private var calificacionTextView: TextView = itemView.findViewById(R.id.siteCalification)

        fun bind(site: Site){
            titleTextView.text = site.titulo
            descripcionTextView.text = site.descripcion
            ubicacionTextView.text = site.ubicacion



        }

    }

}