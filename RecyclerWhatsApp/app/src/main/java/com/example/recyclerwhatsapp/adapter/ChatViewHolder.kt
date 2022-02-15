package com.example.recyclerwhatsapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerwhatsapp.Chat
import com.example.recyclerwhatsapp.R
import com.example.recyclerwhatsapp.databinding.ItemChatBinding
import de.hdodenhof.circleimageview.CircleImageView

class ChatViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemChatBinding.bind(view)

    fun render(chatModel: Chat, onClickListener:(Chat)-> Unit){

        binding.tvNombreContacto.text = chatModel.nombre_usuario

        if(chatModel.contenido_mensaje.length >= 57){
            var msg: String = ""
            for (i in 0..51){
                msg+=chatModel.contenido_mensaje[i]
            }
            msg+="..."
            binding.tvMensaje.text = msg
        }else{
            binding.tvMensaje.text = chatModel.contenido_mensaje
        }

        binding.tvHora.text = chatModel.hora_mensaje
        binding.tvCantidad.text = "3"
        Glide.with(binding.ivphoto.context).load(chatModel.photo_usuario).into(binding.ivphoto)


        itemView.setOnClickListener { onClickListener(chatModel)}

    }
}