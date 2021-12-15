package com.example.parispoi.ui.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parispoi.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val torreEiffel = LatLng(48.85838419677619, 2.294942637450299)
        googleMap.addMarker(MarkerOptions().position(torreEiffel).title("Aqui se ubica la torre Eiffel"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(torreEiffel, 15F))

        val museo = LatLng(48.86070636797204, 2.3379175828316403)
        googleMap.addMarker(MarkerOptions().position(museo).title("Aqui se ubica el museo de Louvre"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(museo, 15F))

        val catedral = LatLng(48.85309525022425, 2.3502883356025825)
        googleMap.addMarker(MarkerOptions().position(catedral).title("Aqui se ubica la Catedral de Notre Dame"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(catedral, 15F))

        val arco = LatLng(48.873982206280886, 2.295510295121662)
        googleMap.addMarker(MarkerOptions().position(arco).title("Aqui se ubica el Arco del triunfo"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arco, 15F))

        val plaza = LatLng(48.86568174508975, 2.3208950184141717)
        googleMap.addMarker(MarkerOptions().position(plaza).title("Aqui se ubica la Plaza de la concordia"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plaza, 15F))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}