package com.example.parispoi.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.parispoi.databinding.FragmentListBinding
import com.example.parispoi.model.Site
import com.example.parispoi.model.SiteItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var siteAdapter: SiteAdapter
    private var listSite: ArrayList<SiteItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listSite = loadMockSitesFromJson()
        siteAdapter = SiteAdapter(listSite, onItemClicked = { onSiteClicked(it) })

    }

    private fun onSiteClicked(site: SiteItem) {

    }

    private fun loadMockSitesFromJson(): ArrayList<SiteItem> {

        var sitesString: String =
            context?.assets?.open("sites.json")?.bufferedReader().use { it!!.readText() }
        var gson = Gson()
        val sitesListConvert = gson.fromJson(sitesString, Site::class.java)

        return sitesListConvert
    }
}