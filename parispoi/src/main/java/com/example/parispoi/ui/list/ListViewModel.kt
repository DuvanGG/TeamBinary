package com.example.parispoi.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parispoi.data.SitesRepository
import com.example.parispoi.model.Site
import com.example.parispoi.model.SiteItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitesLoad : MutableLiveData<ArrayList<SiteItem>> = MutableLiveData()
    val onSitesLoaded : LiveData<ArrayList<SiteItem>> = sitesLoad

    private val repository = SitesRepository()

    fun getSitesFromServer(){
        GlobalScope.launch (Dispatchers.IO) {
            sitesLoad.postValue(repository.getSites())
        }
    }

    fun loadMockSitesFromJson(sitesString: InputStream?) {
        val sitesString = sitesString?.bufferedReader().use {it!!.readText()}
        var gson = Gson()
        sitesLoad.value = gson.fromJson(sitesString, Site::class.java)

    }

}