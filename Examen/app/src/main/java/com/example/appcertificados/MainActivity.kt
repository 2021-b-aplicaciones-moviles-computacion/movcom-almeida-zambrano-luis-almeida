package com.example.appcertificados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciamos el boton de inicio de la aplicación

        val btn_IniciarApp = findViewById<Button>(R.id.btn_AddPersona)
        btn_IniciarApp.setOnClickListener{
            //Conectamos el intent con la activity de home
            val intent = Intent(this, home_app::class.java)
        }
    }
}