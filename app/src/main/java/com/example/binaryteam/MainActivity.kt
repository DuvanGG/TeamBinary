package com.example.binaryteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var ListSites : ArrayList<Site>
    private lateinit var siteAdapter: SiteAdapter
    private lateinit var sitesRecyclerView: RecyclerView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sitesRecyclerView = findViewById(R.id.sitesList)

        ListSites = createMockSites()

        siteAdapter = SiteAdapter(ListSites)


        sitesRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        sitesRecyclerView.adapter = siteAdapter
    }

    private fun createMockSites(): ArrayList<Site>{
        return arrayListOf(
            Site("Catedral de notre Dame", "Esta catedral es de las mas grandes del mundo", 5,"Paris","Imagen"),
            Site("Museo", "El museo es el mejor", 4,"Paris","Imagen")

        )
    }
}