package com.example.examenalmiibim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenalmiibim.databinding.ActivityEditarPersonaBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditarPersona : AppCompatActivity() {

    private lateinit var binding: ActivityEditarPersonaBinding
    var ActualizarPersona = FireStorePersona("","","")
    val db = Firebase.firestore
    val Personas = db.collection("personas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarPersonaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Editar Persona"
    }

    override fun onStart() {
        super.onStart()

        ActualizarPersona = intent.getParcelableExtra<FireStorePersona>("Persona")!!

        binding.txtNombre.setText(ActualizarPersona.nombre.toString())
        binding.txtCorreo.setText(ActualizarPersona.email.toString())
        binding.txtEdad.setText(ActualizarPersona.edad.toString())

        binding.btnGuardar.setOnClickListener {
            Personas.document("${ActualizarPersona.email}").update(
                "nombre", binding.txtNombre.text.toString(),
                "edad", binding.txtEdad.text.toString()
            )
            onBackPressed()
            Toast.makeText(this,"Información Actualizada",Toast.LENGTH_LONG).show()
        }

        binding.btnCancelar.setOnClickListener {
            onBackPressed()
        }
    }
}