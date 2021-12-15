package com.example.parispoi.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parispoi.databinding.FragmentListBinding
import com.example.parispoi.ui.main.MainActivity
import com.example.parispoi.model.SiteItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var siteAdapter: SiteAdapter
    private var listSites: ArrayList<SiteItem> = arrayListOf()
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        //listViewModel.loadMockSitesFromJson(context?.assets?.open("sites.json"))

        listViewModel.getSitesFromServer()

        listViewModel.onSitesLoaded.observe(viewLifecycleOwner, { result ->
            onSiteLoadedSubscribe(result)

        })

        siteAdapter = SiteAdapter(listSites, onItemClicked = { onSiteClicked(it) })

        listBinding.sitesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = siteAdapter
            setHasFixedSize(false)
        }


    }

    private fun onSiteLoadedSubscribe(result: ArrayList<SiteItem>?) {
        result?.let { listSites ->
            siteAdapter.appendItems(listSites)


            /*
            this.listSites = listSites
            siteAdapter.notifyDataSetChanged()*/
        }



    }

    private fun onSiteClicked(site: SiteItem) {
       findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(site = site))

    }

    /*private fun loadMockSitesFromJson(): ArrayList<SiteItem> {

        var sitesString: String =
            context?.assets?.open("sites.json")?.bufferedReader().use { it!!.readText() }
        var gson = Gson()
        val sitesListConvert = gson.fromJson(sitesString, Site::class.java)

        return sitesListConvert
    }*/
}