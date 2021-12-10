package com.example.parispoi.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parispoi.model.Site
import com.example.parispoi.model.SiteItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitesLoad : MutableLiveData<ArrayList<SiteItem>> = MutableLiveData()
    val onSitesLoaded : LiveData<ArrayList<SiteItem>> = sitesLoad

    fun loadMockSitesFromJson(sitesString: InputStream?) {
        val sitesString = sitesString?.bufferedReader().use {it!!.readText()}
        var gson = Gson()
        sitesLoad.value = gson.fromJson(sitesString, Site::class.java)

    }

}