package com.example.examenalmiibim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.examenalmiibim.databinding.ActivityAddPersonaBinding
import com.example.examenalmiibim.databinding.ActivityHomeAppBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddPersona : AppCompatActivity() {

    private lateinit var binding: ActivityAddPersonaBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Agregar Persona"



        binding.btnGuardar.setOnClickListener {
            db.collection("personas").document(binding.txtEmail.text.toString()).set(
                hashMapOf(
                    "nombre" to binding.txtNombre.text.toString(),
                    "email" to binding.txtEmail.text.toString(),
                    "edad" to binding.txtEdad.text.toString()
                ),

            ).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Usuario Agregado Correctamente", Toast.LENGTH_LONG).show()
                    binding.txtNombre.setText("")
                    binding.txtEmail.setText("")
                    binding.txtEdad.setText("")
                    binding.txtNombre.requestFocus()
                } else{
                    Toast.makeText(this, "FALLAMOS", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnCancelar.setOnClickListener {
            onBackPressed()
        }




    }
}