package com.example.recyclerwhatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwhatsapp.adapter.ChatAdapter
import com.example.recyclerwhatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }

    fun initRecyclerView(){

        binding.rvChat.layoutManager = LinearLayoutManager(this)
        binding.rvChat.adapter =
            ChatAdapter(ChatProvider.chatList) {chat ->
                onItemSelected(
                    chat
                )
            }
    }

    fun onItemSelected(chat: Chat){
        val intent = Intent(this,ChatActivity::class.java )
        intent.putExtra("INTENT_Photo", chat.photo_usuario)
        intent.putExtra("INTENT_NombreContacto", chat.nombre_usuario)
        intent.putExtra("INTENT_ultVez", chat.ultima_vez)
        intent.putExtra("INTENT_Mensaje", chat.contenido_mensaje)
        intent.putExtra("INTENT_cantidad", chat.cantidad)

        startActivity(intent)
    }
}