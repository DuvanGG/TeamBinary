package com.example.binaryteam


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.io.InputStream
import java.util.ArrayList


class SiteListFragment : Fragment() {


    private lateinit var siteAdapter : SiteAdapter
    private var mSite: ArrayList<Site> = ArrayList()
    private lateinit var recycler: RecyclerView
    private lateinit var contexto: Context




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.site_list_fragment, container, false)

        recycler = view.findViewById(R.id.site_list)
        initRecyclerView(view)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateSites()

    }

    //    agregar contexto
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context

    }


    private fun initRecyclerView(view: View){

        mSite = arrayListOf()

        recycler.addItemDecoration(
            DividerItemDecoration(
                contexto,
                DividerItemDecoration.VERTICAL //vertical se refiera a la lista
            )
        )
        recycler.layoutManager = LinearLayoutManager(activity)

        SiteAdapter = SiteAdapter(mSite, contexto)
        {
            site ->   siteOnClick(site,view)
        }
        recycler.adapter = siteAdapter
    }

    private fun siteOnClick(site: Site,view: View){


        val action = SiteListFragmentDirections.navigateToSiteDetails(site.titulo,site.descripcion,site.temperatura,site.imagen,site.ubicacion,site.calificacion.toFloat())
       Navigation.findNavController((view)).navigate(action)


    }



    @SuppressLint("NotifyDataSetChanged")
    private fun generateSites() {
        val sitesString = readSiteJsonFile()
        try {
            val sitesJson = JSONArray(sitesString)
            for (i in 0 until sitesJson.length()) {
                val siteJson = sitesJson.getJSONObject(i)
                val site = Site(
                    siteJson.getString("titulo"),
                    siteJson.getString("calificacion"),
                    siteJson.getString("temperatura"),
                    siteJson.getString("imagenURL"),
                    siteJson.getString("descripcion"),
                    siteJson.getString("ubicacion")
                )
                Log.d(TAG, "generateContacts: $site")
                mSite.add(site)
            }

            siteAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }



    fun readSiteJsonFile(): String? {

        var contactsString: String? = null
        try {
            val inputStream: InputStream = contexto.assets.open("sites.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            contactsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return contactsString
    }


    companion object{

            private const val TAG = "SiteListFragment"



    }


}