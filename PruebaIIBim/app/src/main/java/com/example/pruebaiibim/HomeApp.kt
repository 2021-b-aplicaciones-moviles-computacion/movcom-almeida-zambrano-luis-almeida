package com.example.pruebaiibim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class HomeApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_app)

        //Setup
        val bundle:Bundle? = intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String?= bundle?.getString("provider")

        setup(email?:"", provider?:"")
    }

    private fun setup(email: String, provider: String){
        title = "Home App"

        val etEmail = findViewById<TextView>(R.id.tvEmail)
        val etProvider = findViewById<TextView>(R.id.tvProvider)

        etEmail.text = email
        etProvider.text = provider

        val btnLogOut = findViewById<Button>(R.id.btnLogOut)
        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }


    }
}