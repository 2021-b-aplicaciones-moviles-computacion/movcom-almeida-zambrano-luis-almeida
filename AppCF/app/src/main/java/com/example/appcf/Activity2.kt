package com.example.appcf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        val lblNombreUsuario = findViewById<TextView>(R.id.lblNombreUsuario)


        //Resivimos parametros desde la otra actividad
        var nombre_usuario : String? = intent.getStringExtra("nombre_usuario")

        lblNombreUsuario.setText(nombre_usuario)



        btnRegresar.setOnClickListener {
            // Iniciamos la otra actividad
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}