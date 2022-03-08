package com.example.proyectoiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.proyectoiibim.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        //setup
        setup()
    }

    private fun setup(){

        binding.btnRegister.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.txtEmail.text.toString(),
                binding.txtPassword.text.toString()
            ).addOnCompleteListener {
                if(it.isSuccessful){
                    //Acción cuando el login es correcto
                    Log.d("Registro-Correcto", "createUserWithEmail:success")
                    binding.txtEmail.setText("")
                    binding.txtPassword.setText("")
                } else{
                    //Acción cuando el login no es correcto
                    Log.w("Registro-Incorrecto", "createUserWithEmail:failure", it.exception)
                    Toast.makeText(this, "El usuario no se ha podido registrar", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.txtEmail.text.toString(),
                binding.txtPassword.text.toString()
            ).addOnCompleteListener {
                if(it.isSuccessful){
                    //Acción cuando el login es correcto
                    Log.d("Inicio-Correcto", "createUserWithEmail:success")
                    startHome()
                } else{
                    //Acción cuando el login no es correcto
                    Log.w("Inicio-Incorrecto", "createUserWithEmail:failure", it.exception)
                    Toast.makeText(this, "El usuario no se ha podido logear", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun startHome(){
        val intent = Intent(this, AddCarrera::class.java)
        startActivity(intent)
    }



}