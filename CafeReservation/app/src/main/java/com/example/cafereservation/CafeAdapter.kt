package com.example.cafereservation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafereservation.R
import com.example.cafereservation.Cafe

class CafeAdapter(private var cafes: List<Cafe>) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {

    class CafeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cafeName: TextView = itemView.findViewById(R.id.cafe_name)
        val cafeLocation: TextView = itemView.findViewById(R.id.cafe_location)
        val cafeImage: ImageView = itemView.findViewById(R.id.cafe_image) // Tambahkan ImageView untuk gambar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cafe, parent, false)
        return CafeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        val cafe = cafes[position]
        holder.cafeName.text = cafe.name
        holder.cafeLocation.text = cafe.location
        holder.cafeImage.setImageResource(cafe.imageResId) // Set gambar dari drawable
    }

    override fun getItemCount(): Int {
        return cafes.size
    }

    fun updateCafes(newCafes: List<Cafe>) {
        cafes = newCafes
        notifyDataSetChanged()
    }
}
