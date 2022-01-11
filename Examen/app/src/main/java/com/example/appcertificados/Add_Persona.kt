package com.example.appcertificados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class Add_Persona : AppCompatActivity() {

    var nextId = 0
    var lastId = 0
    var nombre = ""
    var edad = ""
    var mail = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_persona)
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida","onStart")

        var len_ListaPersona = BDMemoria.arr_persona.lastIndex

        BDMemoria.arr_persona.forEachIndexed{ indice: Int, persona : Persona ->
            Log.i("testExamen","${persona.id_persona} -> ${persona.nombre}")
            if (indice == len_ListaPersona){
                lastId = persona.id_persona
            }
        }

        nextId = lastId+1

        var txt_nombre = findViewById<TextInputEditText>(R.id.ti_addnombre)
        var txt_edad = findViewById<TextInputEditText>(R.id.ti_addedad)
        var txt_mail = findViewById<TextInputEditText>(R.id.ti_addmail)

        var btn_AddPersona = findViewById<Button>(R.id.btn_AddCertificado)
        btn_AddPersona.setOnClickListener {
            nombre = txt_nombre.text.toString()
            edad = txt_edad.text.toString()
            mail = txt_nombre.text.toString()

            //Agregamos una nueva persona a la BD en memoria
            BDMemoria.arr_persona.add(Persona(nextId,nombre,edad,mail))

            //Actualizamos la lista del Home
            val intentAddSucces = Intent(this, home_app::class.java)
            startActivity(intentAddSucces)
        }

        var btn_Cancelar = findViewById<Button>(R.id.btn_Cancelar)
        btn_Cancelar.setOnClickListener {
            val intentAddCancel = Intent(this, home_app::class.java)
            startActivity(intentAddCancel)
        }
    }
}