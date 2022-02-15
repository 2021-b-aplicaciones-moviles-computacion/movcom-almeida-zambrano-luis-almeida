package com.example.recyclerwhatsapp

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
        Toast.makeText(this, chat.nombre_usuario, Toast.LENGTH_SHORT).show()
    }
}