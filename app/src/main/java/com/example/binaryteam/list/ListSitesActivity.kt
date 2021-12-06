package com.example.binaryteam.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.binaryteam.R
import com.example.binaryteam.model.Site
import com.example.binaryteam.model.SiteItem
import com.google.gson.Gson

class ListSitesActivity : AppCompatActivity() {

    private lateinit var ListSites : ArrayList<SiteItem>
    private lateinit var siteAdapter: SiteAdapter
    private lateinit var sitesRecyclerView: RecyclerView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sitesRecyclerView = findViewById(R.id.sitesList)

        //ListSites = createMockSites()

        ListSites = loadMockSitesFromJson()

        siteAdapter = SiteAdapter(ListSites, onItemClicked = { onSiteClicked(it) })

        sitesRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        sitesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = siteAdapter
            setHasFixedSize(false)
        }



    }

    private fun onSiteClicked(site: SiteItem) {
        Log.d("titulo", site.titulo )

    }

    private fun loadMockSitesFromJson(): ArrayList<SiteItem> {

        var sitesString: String = applicationContext.assets.open("sites.json").bufferedReader().use { it.readText() }
        var gson = Gson()
        val sitesListConvert = gson.fromJson(sitesString, Site::class.java)

        return sitesListConvert

    }

    /*private fun createMockSites(): ArrayList<Site>{
        return arrayListOf(
            Site("Catedral de notre Dame", "Esta catedral es de las mas grandes del mundo", 5,"Paris","https://www.viajeroscallejeros.com/wp-content/uploads/2020/02/torre-eiffel.jpg"),
            Site("Museo de lov", "El museo es el mejor", 4,"Paris","https://www.viajeroscallejeros.com/wp-content/uploads/2020/02/torre-eiffel.jpg") ,
            Site("Museo de lovbdre", "El museo es el mejor", 4,"Paris","https://sitiosturisticos.com/wp-content/uploads/2012/07/theatre-du-chatele-Paris-300x199.jpg")

        )
    }*/
}