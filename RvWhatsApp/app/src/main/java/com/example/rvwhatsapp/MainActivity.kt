package com.example.rvwhatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvwhatsapp.adapter.ChatAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.rvChat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChatAdapter(ChatDataProvider.chat_list)
    }
}