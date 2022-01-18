package com.example.grecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GrecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grecycler_view)

        var btn_anterior = findViewById<Button>(R.id.btn_anterior)
        btn_anterior.setOnClickListener{
            //Conectamos el intent con la activity de home
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}