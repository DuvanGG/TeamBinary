package com.example.binaryteam

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.RatingBar
import android.widget.TextView

import kotlin.properties.Delegates


class SiteDescriptionFragment : Fragment() {

    private lateinit var titulo : String
    private lateinit var temperatura : String
    private lateinit var descripcion : String
    private lateinit var ubicacion : String
    private lateinit var imagen : String
    private var calificacion by Delegates.notNull<Float>()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_site_description, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        updateDisplay(view)

    }


    private fun updateDisplay(view: View) {

        val textViewTitle = view.findViewById<TextView>(R.id.titulo).apply {
            text = titulo
        }

        val textViewTemp = view.findViewById<TextView>(R.id.ver_temperatura).apply {
            text = temperatura
        }

        val textViewLocation = view.findViewById<TextView>(R.id.ubicacion).apply {
            text = ubicacion
        }

        val textViewDescription = view.findViewById<TextView>(R.id.ver_description).apply {
            text = descripcion
        }

        val ratingCityValue = view.findViewById<RatingBar>(R.id.ratingBar2).apply {
            rating = calificacion
        }


    }






}