package com.example.proyectoiibim.rvCiclista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoiibim.R
import com.example.proyectoiibim.rvCarrera.Carrera
import com.example.proyectoiibim.rvCarrera.CarreraViewHolder

class CiclistaAdapter(private val ciclistaList: List<Ciclista>, private val onClickListener: (Carrera) ->Unit): RecyclerView.Adapter<CiclistaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarreraViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarreraViewHolder(layoutInflater.inflate(R.layout.item_ciclista, parent, false))
    }

    override fun onBindViewHolder(holder: CarreraViewHolder, position: Int) {
        val item = ciclistaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return ciclistaList.size
    }

}