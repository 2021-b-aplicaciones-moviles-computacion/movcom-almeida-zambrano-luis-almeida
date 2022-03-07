package com.example.examenalmiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenalmiibim.databinding.ActivityEditarCertificadoBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class EditarCertificado : AppCompatActivity() {

    private lateinit var binding: ActivityEditarCertificadoBinding

    var Persona = FireStorePersona("", "", "")
    var Certificado = FireStoreCertificados("", "", "", "")
    val db = FirebaseFirestore.getInstance()
    val Cartificados = db.collection("personas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarCertificadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Editar Certificado"
    }

    override fun onStart() {
        super.onStart()

        Persona = intent.getParcelableExtra<FireStorePersona>("Persona")!!
        Certificado = intent.getParcelableExtra<FireStoreCertificados>("Certificado")!!

        binding.txtNombreCertificado.setText("${Certificado.nombre}")
        binding.txtPlataforma.setText("${Certificado.plataforma}")
        binding.txtFecha.setText("${Certificado.fecha}")

        binding.btnCancelar.setOnClickListener {
            devolverRespuesta()
        }

        binding.btnGuardar.setOnClickListener {
            Cartificados.document("${Persona.email}")
                .collection("Certificado")
                .document("${Certificado.certificadoId}")
                .update(
                    "nombre", binding.txtNombreCertificado.text.toString(),
                    "fecha", binding.txtFecha.text.toString(),
                    "plataforma", binding.txtPlataforma.text.toString()
                )
            Toast.makeText(this, "Certificado actualizado exitosamente", Toast.LENGTH_SHORT).show()
            onBackPressed()
        }
    }

    fun devolverRespuesta() {
        val intent = Intent()
        intent.putExtra("Persona", Persona)
        setResult(
            RESULT_OK,
            intent
        )
        finish()
    }
}