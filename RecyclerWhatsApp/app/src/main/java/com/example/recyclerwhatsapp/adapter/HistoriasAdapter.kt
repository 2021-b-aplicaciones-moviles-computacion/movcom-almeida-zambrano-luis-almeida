package com.example.recyclerwhatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwhatsapp.Historia
import com.example.recyclerwhatsapp.R

class HistoriasAdapter(val historiaList:List<Historia>, private val onClickListener:(Historia)-> Unit):RecyclerView.Adapter<HistoriasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoriasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HistoriasViewHolder(layoutInflater.inflate(R.layout.item_historia,parent,false))
    }

    override fun onBindViewHolder(holder: HistoriasViewHolder, position: Int) {
        val item = historiaList[position]
        holder.render(item, onClickListener, position)
    }

    override fun getItemCount(): Int = historiaList.size
}