package com.example.binaryteam


import com.google.gson.annotations.SerializedName

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
)