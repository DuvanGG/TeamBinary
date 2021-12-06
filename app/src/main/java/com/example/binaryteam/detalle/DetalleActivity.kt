package com.example.binaryteam.detalle

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binaryteam.R
import com.example.binaryteam.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBiding : ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBiding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detalle)

        val titulo = intent.extras?.getString("titulo")
        detalleBiding.titleDetail.text = titulo
    }
}