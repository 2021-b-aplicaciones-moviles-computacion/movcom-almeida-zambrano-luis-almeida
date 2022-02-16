package com.example.recyclerwhatsapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerwhatsapp.Chat
import com.example.recyclerwhatsapp.Historia
import com.example.recyclerwhatsapp.databinding.ItemChatBinding
import com.example.recyclerwhatsapp.databinding.ItemHistoriaBinding

class HistoriasViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemHistoriaBinding.bind(view)

    fun render(historiaModel: Historia, onClickListener:(Historia)-> Unit, position: Int){

        //Cargamos la Foto
        Glide.with(binding.ivPhotoHistoria.context).load(historiaModel.photo_historia).into(binding.ivPhotoHistoria)

        //Cargamos el Nombre
        binding.tvUsuarioHistoria.text = historiaModel.nombre_usuario

        //Cargamos la Hora
        binding.tvHoraHistoria.text = historiaModel.hora_historia

        itemView.setOnClickListener { onClickListener(historiaModel)}



    }

}