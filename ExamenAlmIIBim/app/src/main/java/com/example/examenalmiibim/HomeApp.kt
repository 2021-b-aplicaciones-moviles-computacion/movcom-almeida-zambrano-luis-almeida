package com.example.examenalmiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.examenalmiibim.databinding.ActivityHomeAppBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

enum class ProviderType{
    BASIC
}

class HomeApp : AppCompatActivity() {

    private lateinit var binding: ActivityHomeAppBinding
    private val db = FirebaseFirestore.getInstance()
    private val personas = db.collection("personas")
    private var itemSelected = -1
    private var adapter : ArrayAdapter<FireStorePersona>?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Inicio"

        val bundle:Bundle? = intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String? = bundle?.getString("provider")

        //setup
        setup(email ?: "", provider ?: "")
    }

    override fun onStart() {
        super.onStart()
        updateTrainerList()

        binding.btnCrearPersona.setOnClickListener {
            val intent = Intent(this, AddPersona::class.java)
            startActivity(intent)
        }
    }

    private fun setup(email:String, provider:String){
        title = "Home App"




        binding.btnCrearPersona.setOnClickListener {
            val intent = Intent(this, AddPersona::class.java)
            startActivity(intent)
        }

    }

    //Para poder mostrar el menú contextual
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
        Log.i("context-menu", "ID ${id}")
    }


    //Actualizamos la lista de Personas
    private fun updateTrainerList(){

        personas.get().addOnSuccessListener{ result ->

            var personaList = arrayListOf<FireStorePersona>()

            for (document in result) {
                personaList.add(
                    FireStorePersona(
                        document.get("nombre").toString(),
                        document.get("email").toString(),
                        document.get("edad").toString()
                    )
                )
            }

            adapter = ArrayAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                personaList
            )

            binding.lvPersonas.adapter = adapter
            adapter!!.notifyDataSetChanged()

            registerForContextMenu(binding.lvPersonas)

        }.addOnFailureListener{
            Log.i("ERROR", "Faiuler retreving trainers")
        }
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        var personaSelected:FireStorePersona = adapter!!.getItem(itemSelected)!!
        return when (item.itemId) {
            R.id.mn_editar -> {
                Log.i("context-menu", "Edit position: ${personaSelected.email}")
                val intent = Intent(this, EditarPersona::class.java)
                intent.putExtra("Persona",personaSelected)
                startActivity(intent)
                return true
            }
            R.id.mn_eliminar -> {
                Log.i("context-menu", "Delete position: ${itemSelected}")
                personas.document("${personaSelected.email}").delete()
                    .addOnSuccessListener {
                        Log.i("DELETE-TRAINER","Success")
                    }
                    .addOnFailureListener{
                        Log.i("DELETE-TRAINER","Failure")
                    }
                updateTrainerList()
                return true
            }
            R.id.mn_ver -> {
                Log.i("context-menu", "Pokemons: ${personaSelected}")
                //CAMBIAR MAIN POR LA INTERFAZ DE LA LISTA DE CERTIFICADOS
                val intent = Intent(this, HomeCertificados::class.java)
                intent.putExtra("Persona",personaSelected)
                startActivity(intent)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}