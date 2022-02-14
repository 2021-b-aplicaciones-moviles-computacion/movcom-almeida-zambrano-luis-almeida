package com.example.clonwhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clonwhatsapp.databinding.ItemChatBinding
import com.squareup.picasso.Picasso


class ChatAdapter(val chatData: List<ChatData>): RecyclerView.Adapter<ChatAdapter.chatHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chatHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return chatHolder(layoutInflater.inflate(R.layout.item_chat, parent, false))
    }

    override fun getItemCount(): Int = chatData.size

    override fun onBindViewHolder(holder: chatHolder, position: Int) {
        holder.render(chatData[position])
    }

    class chatHolder(val view:View):RecyclerView.ViewHolder(view){
        val binding = ItemChatBinding.bind(view)
        fun render(chatData : ChatData){
            binding.lblNombreUsuario.text = chatData.nombre_usuario
            binding.lblMensaje.text = chatData.mensaje
            binding.lblHoraMensaje.text = chatData.hora_mensaje
            binding.lblCantidadMensaje.setText(chatData.cantidad_mensaje)
            Picasso.get().load(chatData.img_url).into(binding.imgPerfil)


        }
    }

}