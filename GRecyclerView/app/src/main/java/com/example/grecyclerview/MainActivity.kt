package com.example.grecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_siguiente = findViewById<Button>(R.id.btn_siguiente)
        btn_siguiente.setOnClickListener{
            //Conectamos el intent con la activity de home
            val intent = Intent(this, GrecyclerView::class.java)
            startActivity(intent)
        }
    }
}