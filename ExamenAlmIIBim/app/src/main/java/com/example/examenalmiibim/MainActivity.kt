package com.example.examenalmiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examenalmiibim.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.security.Provider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Iniciar Sesión"

        auth = Firebase.auth

        binding.btnRegistrar.setOnClickListener {
            Toast.makeText(this, "El correo es: ${binding.txtEmail.text.toString().trim()}", Toast.LENGTH_SHORT).show()
            auth.createUserWithEmailAndPassword(binding.txtEmail.text.toString().trim(), binding.txtPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showHomeApp(task.result?.user?.email?:"", ProviderType.BASIC )
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Error-Registro", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "El correo es: ${binding.txtEmail.text.toString().trim()}", Toast.LENGTH_SHORT).show()
            auth.signInWithEmailAndPassword(binding.txtEmail.text.toString().trim(), binding.txtPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showHomeApp(task.result?.user?.email?:"", ProviderType.BASIC )
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Error-Login", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

    private fun showHomeApp(user: String, provider: ProviderType){
        val intent = Intent(this, HomeApp::class.java)
        intent.putExtra("email", user)
        intent.putExtra("provider", provider.name)
        startActivity(intent)
    }
}