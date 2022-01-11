package com.example.appcertificados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class Gui_AddCertificado : AppCompatActivity() {

    var nextId = 0
    var lastId = 0
    var nombre_curso = ""
    var nombre_plataforma = ""
    var fecha = ""
    var posPersona = 0
    var idPersonaOwner = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui_add_certificado)
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida","onStart")

        posPersona = intent.getIntExtra("posPersona",-1)

        Log.i("posPersona","${posPersona}")

        BDMemoria.arr_persona.forEachIndexed{ indice: Int, persona : Persona ->
            Log.i("testExamen","${persona.id_persona} -> ${persona.nombre}")
            if (indice == posPersona){
                idPersonaOwner = persona.id_persona
            }
        }

        var len_Certificados = BDMemoria.arr_certificado.lastIndex

        BDMemoria.arr_certificado.forEachIndexed{ indice: Int, certificado : Certificado ->
            Log.i("testExamen","${certificado.nombre_curso} -> ${certificado.nombre_plataforma}")
            if (indice == len_Certificados){
                lastId = certificado.id_certificado
            }
        }

        nextId = lastId+1

        var ti_nombre_certificado = findViewById<TextInputEditText>(R.id.ti_nombre_certificado)
        var ti_nombre_plataforma = findViewById<TextInputEditText>(R.id.ti_nombre_plataforma)
        var ti_fecha_certificado = findViewById<TextInputEditText>(R.id.ti_fecha_certificado)

        var btn_AddCertificado= findViewById<Button>(R.id.btn_AddCertificado)
        btn_AddCertificado.setOnClickListener {
            nombre_curso = ti_nombre_certificado.text.toString()
            nombre_plataforma = ti_nombre_plataforma.text.toString()
            fecha = ti_fecha_certificado.text.toString()

            BDMemoria.arr_certificado.add(Certificado(nextId,nombre_curso,nombre_plataforma, fecha)
            )
            BDMemoria.arr_persona_x_certificado.add(
                Persona_x_Certificado(idPersonaOwner, nextId)
            )
            devolverRespuesta()
        }

        var btn_Cancelar = findViewById<Button>(R.id.btn_Cancelar)
        btn_Cancelar.setOnClickListener {
            devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("posPersona",posPersona)
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }

}