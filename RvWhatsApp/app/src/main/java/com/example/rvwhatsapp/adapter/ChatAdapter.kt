package com.example.rvwhatsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rvwhatsapp.Chat
import com.example.rvwhatsapp.R

class ChatAdapter(private val chat_list:List<Chat>) : RecyclerView.Adapter<ChatViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ChatViewHolder(layoutInflater.inflate(R.layout.item_chat, parent, false))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = chat_list[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = chat_list.size
}