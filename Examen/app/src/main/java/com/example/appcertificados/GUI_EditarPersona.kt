package com.example.appcertificados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class GUI_EditarPersona : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui_editar_persona)
    }

    override fun onStart() {
        Log.i("ciclo-vida", "onStart")
        super.onStart()

        val posEditar = intent.getIntExtra("posEditar",1)

        var ti_nombre_persona = findViewById<TextInputEditText>(R.id.ti_nombre_persona)
        var ti_edad = findViewById<TextInputEditText>(R.id.ti_edad)
        var ti_mail = findViewById<TextInputEditText>(R.id.ti_mail)

        BDMemoria.arr_persona.forEachIndexed{ indice: Int, persona : Persona ->
            Log.i("testExamen","${persona.id_persona} -> ${persona.nombre}")
            if (indice == posEditar){
                ti_nombre_persona.setText(persona.nombre)
                ti_edad.setText(persona.edad)
                ti_mail.setText(persona.correo)
            }
        }

        val btn_Editar = findViewById<Button>(R.id.btn_Editar)
        btn_Editar.setOnClickListener {
            BDMemoria.arr_persona.forEachIndexed{ indice: Int, persona: Persona ->
                if (indice == posEditar){
                    persona.nombre = (ti_nombre_persona.text.toString())
                    persona.edad = (ti_edad.text.toString())
                    persona.correo = (ti_mail.text.toString())
                }
            }
            val intentEditSucces = Intent(this, home_app::class.java)
            startActivity(intentEditSucces)
        }

        val btn_Cancelar = findViewById<Button>(R.id.btn_Cancelar)
        btn_Cancelar.setOnClickListener{
            val intentEditCancel = Intent(this, home_app::class.java)
            startActivity(intentEditCancel)
        }

    }








}