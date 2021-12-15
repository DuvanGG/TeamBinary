package com.example.parispoi.data

import com.example.parispoi.model.Site
import retrofit2.http.GET

interface ApiService {

    @GET("DuvanGG/TeamBinary/sites")
    suspend fun getSites(): Site

}