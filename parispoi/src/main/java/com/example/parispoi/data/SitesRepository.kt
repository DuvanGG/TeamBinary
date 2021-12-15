package com.example.parispoi.data

class SitesRepository {

    suspend fun getSites() = ApiFactory.retrofit.getSites()
}