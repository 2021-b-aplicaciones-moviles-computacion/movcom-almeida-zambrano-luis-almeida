package com.example.recyclerwhatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.recyclerwhatsapp.adapter.ChatAdapter
import com.example.recyclerwhatsapp.adapter.HistoriasAdapter
import com.example.recyclerwhatsapp.databinding.ActivityHistoriasBinding

class Historias : AppCompatActivity() {

    private lateinit var binding: ActivityHistoriasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.ivPhotoHistoria2.context).load("https://rickandmortyapi.com/api/character/avatar/65.jpeg").into(binding.ivPhotoHistoria2)

        initRecyclerView()

        binding.textView2.setOnClickListener {
            layoutChats()
        }
    }

    fun layoutChats(){
        val intent = Intent(this, MainActivity::class.java )
        startActivity(intent)
    }

    fun initRecyclerView(){

        binding.rvHistorias.layoutManager = LinearLayoutManager(this)
        binding.rvHistorias.adapter =
            HistoriasAdapter(HistoriaProvider.historiaList) { historia ->
                onItemSelected(
                    historia
                )
            }
    }

    fun onItemSelected(historia: Historia){

        val intent = Intent(this, VistaHistoria::class.java)
        intent.putExtra("INTENT_NombreUsuario", historia.nombre_usuario)
        intent.putExtra("INTENT_HoraHistoria", historia.hora_historia)
        intent.putExtra("INTENT_PhotoHistoria", historia.photo_historia)
        startActivity(intent)
    }
}