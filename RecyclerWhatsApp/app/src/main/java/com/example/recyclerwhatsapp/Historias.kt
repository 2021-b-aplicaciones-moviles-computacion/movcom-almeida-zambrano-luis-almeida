package com.example.recyclerwhatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerwhatsapp.databinding.ActivityHistoriasBinding
import com.example.recyclerwhatsapp.databinding.ActivityMainBinding

class Historias : AppCompatActivity() {

    private lateinit var binding: ActivityHistoriasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.setOnClickListener {
            layoutChats()
        }
    }

    fun layoutChats(){
        val intent = Intent(this, MainActivity::class.java )
        startActivity(intent)
    }
}