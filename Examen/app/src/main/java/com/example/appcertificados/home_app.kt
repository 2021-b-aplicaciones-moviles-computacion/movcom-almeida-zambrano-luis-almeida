package com.example.appcertificados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class home_app : AppCompatActivity() {

    // Creamos una variable para ver que item está seleccionado en el ListView
    // Lo inicializamos en la posición 0 por defecto
    var idItemSelected = 0


    // Ciclo de vida cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_app)
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "onStart")

        // Instanciamos la ListView de la GUI
        val lv_personas = findViewById<ListView>(R.id.lv_personas)


    }
}