package com.example.pruebaiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.pruebaiibim.databinding.ActivityHomeAppBinding
import com.example.pruebaiibim.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth


        binding.btnRegistrar.setOnClickListener {
            auth.createUserWithEmailAndPassword(binding.etUser.toString(), binding.etPassword.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showHome(task.result?.user?.email?:"", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
        }

        binding.btnLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.etUser.toString(), binding.etPassword.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        showHome(task.result?.user?.email?:"", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error de autenticación de usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email:String, provider: ProviderType){

        val intent = Intent(this, HomeApp::class.java)
        intent.putExtra("email", email)
        intent.putExtra("provider", provider.name)

        startActivity(intent)
    }
}