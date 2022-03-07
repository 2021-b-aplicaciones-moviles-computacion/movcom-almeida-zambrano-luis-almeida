package com.example.examenalmiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenalmiibim.databinding.ActivityAddCertificadoBinding
import com.example.examenalmiibim.databinding.ActivityAddPersonaBinding
import com.google.firebase.firestore.FirebaseFirestore

class AddCertificado : AppCompatActivity() {

    private lateinit var binding: ActivityAddCertificadoBinding
    private val db = FirebaseFirestore.getInstance()

    var Persona = FireStorePersona("", "", "")
    val personas = db.collection("personas")
    val certificados = db.collection("Certificados")
    var idSelected = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCertificadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()

        Persona = intent.getParcelableExtra<FireStorePersona>("Persona")!!
        val personaSubcollection = personas.document("${Persona.email}").collection("Certificado")

        binding.btnCancelar.setOnClickListener {
            devolverRespuesta()
        }

        certificados.get().addOnSuccessListener { result ->

            binding.btnGuardar.setOnClickListener {
                guardarCertificado()
                var certificado = hashMapOf(
                    "persona" to Persona.email.toString(),
                    "nombre" to binding.txtNombre.text.toString(),
                    "plataforma" to binding.txtPlataforma.text.toString(),
                    "fecha" to binding.txtFecha.text.toString()
                )
                personaSubcollection.add(certificado).addOnSuccessListener {
                    binding.txtNombre.text.clear()
                    binding.txtPlataforma.text.clear()
                    binding.txtFecha.text.clear()
                    onBackPressed()
                    Toast.makeText(this, "Certificado registrado exitosamente", Toast.LENGTH_LONG)
                        .show();
                }.addOnFailureListener {
                }
            }
        }
    }

    fun devolverRespuesta() {
        val intent = Intent()
        intent.putExtra("PokemonTrainer", Persona)
        setResult(
            RESULT_OK,
            intent
        )
        finish()
    }

    fun guardarCertificado(){

        db.collection("losCertificados").document().set(
            hashMapOf(
                "nombre" to binding.txtNombre.text.toString(),
                "plataforma" to binding.txtPlataforma.text.toString(),
                "fecha" to binding.txtFecha.text.toString()
            ),

            ).addOnCompleteListener {
            if (it.isSuccessful){

            } else{

            }
        }

    }


}