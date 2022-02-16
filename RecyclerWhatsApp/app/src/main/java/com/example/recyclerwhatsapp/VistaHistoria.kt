package com.example.recyclerwhatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recyclerwhatsapp.databinding.ActivityHistoriasBinding
import com.example.recyclerwhatsapp.databinding.ActivityVistaHistoriaBinding

class VistaHistoria : AppCompatActivity() {

    private lateinit var binding: ActivityVistaHistoriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVistaHistoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAndShowInfo()

        binding.ivFotoHistoria.setOnClickListener{
            cargarHistorias()
        }
    }

    fun getAndShowInfo(){
        val bundle = intent.extras

        //Cargamos la Foto de Usuario
        Glide.with(binding.ivPhotoUsuarioHistoria.context).load(bundle?.get("INTENT_PhotoHistoria")).into(binding.ivPhotoUsuarioHistoria)

        //Cargamos la foto
        Glide.with(binding.ivFotoHistoria.context).load(bundle?.get("INTENT_PhotoHistoria")).into(binding.ivFotoHistoria)

        //Cargamos el nombre
        binding.tvUsuarioHistoria.text = bundle?.get("INTENT_NombreUsuario") as String?

        //Cargamos la Hora
        binding.tvHoraHistoria.text = bundle?.get("INTENT_HoraHistoria") as String?

    }

    fun cargarHistorias(){
        val intent = Intent(this, Historias::class.java)
        startActivity(intent)
    }
}