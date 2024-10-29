package com.example.cafereservation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafereservation.adapter.CafeAdapter

class CafeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cafeAdapter: CafeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk fragment
        val view = inflater.inflate(R.layout.fragment_cafe_list, container, false)

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Daftar cafe statis dengan gambar dari drawable
        val cafeList = listOf(
            Cafe("Casa De Alter", "Jl. Perak II No.15, Kp. Jao, Kec. Padang Bar., Kota Padang, Sumatera Barat", R.drawable.cafe1), // Ganti dengan nama file drawable
            Cafe("Cafe Merjer", "Café Merjer, Jl. Ujung Gurun No.88A, Padang Pasir, Kec. Padang Bar., Kota Padang, Sumatera Barat 25115, Indonesia", R.drawable.cafe2),
            Cafe("Cafe Hills", "Jl, Bukit Gado-gado, Kec. Padang Sel., Kota Padang, Sumatera Barat", R.drawable.cafe3)
        )

        // Inisialisasi adapter dengan data statis
        cafeAdapter = CafeAdapter(cafeList)
        recyclerView.adapter = cafeAdapter

        return view
    }
}
