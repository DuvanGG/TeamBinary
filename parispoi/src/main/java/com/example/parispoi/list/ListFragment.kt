package com.example.parispoi.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parispoi.databinding.FragmentListBinding
import com.example.parispoi.main.MainActivity
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
        (activity as MainActivity?)?.hideIcon()
        listSite = loadMockSitesFromJson()
        siteAdapter = SiteAdapter(listSite, onItemClicked = { onSiteClicked(it) })

        listBinding.sitesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = siteAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSiteClicked(site: SiteItem) {
       findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(site = site))

    }

    private fun loadMockSitesFromJson(): ArrayList<SiteItem> {

        var sitesString: String =
            context?.assets?.open("sites.json")?.bufferedReader().use { it!!.readText() }
        var gson = Gson()
        val sitesListConvert = gson.fromJson(sitesString, Site::class.java)

        return sitesListConvert
    }
}