package com.example.proyectoiibim.rvCarrera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoiibim.R

class CarreraAdapter(private val carreraList: List<Carrera>, private val onClickListener: (Carrera) ->Unit): RecyclerView.Adapter<CarreraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarreraViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarreraViewHolder(layoutInflater.inflate(R.layout.item_carrera, parent, false))
    }

    override fun onBindViewHolder(holder: CarreraViewHolder, position: Int) {
        val item = carreraList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return carreraList.size
    }

}