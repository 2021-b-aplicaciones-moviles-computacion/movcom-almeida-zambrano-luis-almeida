package com.example.recyclerwhatsapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwhatsapp.SuperHero

class SuperHeroAdapter(val superheroList:List<SuperHero>) : RecyclerView.Adapter<SuperHeroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {

    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = superheroList.size
}