package com.example.binaryteam.detalle

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binaryteam.R
import com.example.binaryteam.databinding.ActivityDetalleBinding
import com.example.binaryteam.model.Site
import com.example.binaryteam.model.SiteItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBiding : ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detalleBiding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBiding.root)

        val site : SiteItem = intent.extras?.getSerializable("site") as SiteItem
        with(detalleBiding){
            titleDetail.text = site.titulo
            Picasso.get().load(site.imagenURL).into(imageDetail)
            descriptionDetail.text = site.descripcion
            ratingDetail.rating = site.calificacion.toFloat()
        }
    }
}