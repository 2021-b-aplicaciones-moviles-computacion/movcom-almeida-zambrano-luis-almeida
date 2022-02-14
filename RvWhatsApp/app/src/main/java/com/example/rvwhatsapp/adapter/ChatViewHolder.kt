package com.example.rvwhatsapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvwhatsapp.Chat
import com.example.rvwhatsapp.R


class ChatViewHolder(view : View): RecyclerView.ViewHolder(view) {

    val nombre_usuario = view.findViewById<TextView>(R.id.tvNombre)
    val mensaje = view.findViewById<TextView>(R.id.tvMensaje)
    val hora = view.findViewById<TextView>(R.id.tvHora)
    val cantidad = view.findViewById<TextView>(R.id.tvCantidad)
    val photo = view.findViewById<ImageView>(R.id.img_perfil)

    fun render(chatDataProviderModel : Chat){
        nombre_usuario.text = chatDataProviderModel.nombre_usuario
        mensaje.text = chatDataProviderModel.mensaje
        hora.text = chatDataProviderModel.hora_mensaje
        cantidad.setText(chatDataProviderModel.cantidad_mensaje)


    }
}