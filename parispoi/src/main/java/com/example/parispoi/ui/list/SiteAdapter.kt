package com.example.parispoi.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parispoi.R
import com.example.parispoi.model.SiteItem
import com.squareup.picasso.Picasso

class SiteAdapter (
    private val sitesList: ArrayList<SiteItem>,
    private val onItemClicked: (SiteItem) -> Unit

) : RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.site_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val site = sitesList[position]
        holder.itemView.setOnClickListener{ onItemClicked(sitesList[position])}
        holder.bind(site)

    }

    override fun getItemCount(): Int {
        return sitesList.size

    }

    fun appendItems(newItems: ArrayList<SiteItem>){
        sitesList.clear()
        sitesList.addAll(newItems)
        notifyDataSetChanged()

    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var titleTextView: TextView = itemView.findViewById(R.id.siteTitle)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.siteDescription)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.siteImage)
        private var raitingDetail: RatingBar = itemView.findViewById(R.id.ratingDetail)


        fun bind(site: SiteItem){
            titleTextView.text = site.titulo
            descriptionTextView.text = site.descripcion
            raitingDetail.rating = site.calificacion.toFloat()
            Picasso.get().load(site.imagenURL).into(pictureImageView);

        }

    }

}