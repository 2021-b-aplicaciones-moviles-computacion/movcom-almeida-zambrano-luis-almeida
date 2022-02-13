package com.example.a02firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Iniciamos el proceso de Login
        val botonlogin = findViewById<Button>(R.id.btn_loggin)
        botonlogin.setOnClickListener { llamarLoginUsuario() }
    }
}

fun llamarLoginUsuario(){
    val providers = arrayListOf(
        AuthUI.IdConfig.EmailBuilder().build()
    )
}