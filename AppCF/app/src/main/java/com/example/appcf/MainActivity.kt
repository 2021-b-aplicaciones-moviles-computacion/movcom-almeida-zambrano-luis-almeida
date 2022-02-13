package com.example.appcf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toastButton = findViewById<Button>(R.id.toastButton)
        var txtNombre = findViewById<TextView>(R.id.txtNombre)

        toastButton.setOnClickListener {
            //Mostramos un mensaje por un periodo de tiempo
            Toast.makeText(this, "Soy un Toast", Toast.LENGTH_LONG).show()

            // Iniciamos la otra actividad
            val intent = Intent(this, Activity2::class.java)

            //Enviamos datos de una actividad a otra
            intent.putExtra("nombre_usuario", txtNombre.text.toString())

            startActivity(intent)
        }

    }
}