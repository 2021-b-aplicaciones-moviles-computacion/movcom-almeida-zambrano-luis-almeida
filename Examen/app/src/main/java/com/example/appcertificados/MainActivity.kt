package com.example.appcertificados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciamos el boton de inicio de la aplicación

        val btn_IniciarApp = findViewById<Button>(R.id.btn_AddElement)
        btn_IniciarApp.setOnClickListener{

        }
    }
}