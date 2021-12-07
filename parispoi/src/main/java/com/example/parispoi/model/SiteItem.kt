package com.example.parispoi.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SiteItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("imagenURL")
    val imagenURL: String,
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("ubicacion")
    val ubicacion: String
): Serializable