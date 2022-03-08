package com.example.proyectoiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectoiibim.databinding.ActivityAddCarreraBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddCarrera : AppCompatActivity() {

    private lateinit var binding: ActivityAddCarreraBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCarreraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup
        setup()
    }

    private fun setup() {

        binding.btnRegistrarEtapas.setOnClickListener {registrarCarrera()
        }
        binding.btnVerEtapas.setOnClickListener {
            val intent = Intent(this, HomeApp::class.java)
            startActivity(intent)
        }

        binding.btnAdd.setOnClickListener {
            registrarCarrera()
        }

    }


    private fun registrarCarrera(){
        db.collection("carreras").document().set(
            hashMapOf(
                "nombre" to binding.txtNombreCarrera.text.toString(),
                "fecha" to binding.txtFechaCarrera.text.toString(),
                "distancia" to binding.txtDistanciaCarrera.text.toString(),
                "etapas" to binding.txtNumeroEtapas.text.toString(),
                "imgUrl" to binding.txtImg.text.toString(),
                "actual" to true
            )
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                //Acción cuando se registra correctamente una carrera
                Toast.makeText(
                    this,
                    "Carrera Registrada\n${binding.txtNombreCarrera.text.toString()}",
                    Toast.LENGTH_LONG

                ).show()
                binding.txtNombreCarrera.setText("")
                binding.txtFechaCarrera.setText("")
                binding.txtDistanciaCarrera.setText("")
                binding.txtNumeroEtapas.setText("")
                binding.txtImg.setText("")
                binding.txtImg.requestFocus()

            } else {
                Toast.makeText(this, "Falla en el registro de carrera", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}