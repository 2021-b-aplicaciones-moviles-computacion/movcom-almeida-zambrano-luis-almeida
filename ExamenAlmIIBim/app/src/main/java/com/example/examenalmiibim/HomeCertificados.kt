package com.example.examenalmiibim

import android.app.Activity
import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.examenalmiibim.databinding.ActivityHomeCertificadosBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeCertificados : AppCompatActivity() {

    private lateinit var binding: ActivityHomeCertificadosBinding

    var itemSelected = 0
    var Persona = FireStorePersona("","","")
    val db = FirebaseFirestore.getInstance()
    val personas = db.collection("personas")
    var adapter: ArrayAdapter<FireStoreCertificados>? = null

    var resultAddNewCertificado = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            if(result.data != null) {
                val data = result.data
                Persona = intent.getParcelableExtra<FireStorePersona>("Persona")!!
            }
        }
    }

    var resultEditCertificado = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            if(result.data != null) {
                val data = result.data
                Persona = intent.getParcelableExtra<FireStorePersona>("Persona")!!
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeCertificadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        Persona = intent.getParcelableExtra<FireStorePersona>("Persona")!!
        updatePokemonList()
        binding.lblPersona.setText("Usuario: ${Persona.nombre}")


        binding.btnAgregar.setOnClickListener {
            val intent = Intent(this, AddCertificado::class.java)
            intent.putExtra("Persona",Persona)
            resultAddNewCertificado.launch(intent)
        }

        binding.btnCancelar.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.mn_certificados, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        var certificadoSelected:FireStoreCertificados = adapter!!.getItem(itemSelected)!!
        return when (item.itemId) {
            R.id.mn_certificado_editar -> {
                val itent = Intent(this, EditarCertificado::class.java)
                itent.putExtra("Persona",Persona)
                itent.putExtra("Certificado",certificadoSelected)
                resultEditCertificado.launch(itent)
                return true
            }
            R.id.mn_certificado_eliminar -> {
                val CertificadosSubcollection = personas.document("${Persona.email}")
                    .collection("Certificados")
                    .document("${certificadoSelected.nombre}")
                    .delete()
                    .addOnSuccessListener {
                        Log.i("DELETE-POKEMON","Success")
                    }
                    .addOnFailureListener{
                        Log.i("DELETE-POKEMON","Failure")
                    }
                updatePokemonList()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    fun updatePokemonList(){

        val certificadoSubcollection = personas.document("${Persona.email}")
            .collection("Certificado")
            .whereEqualTo("persona","${Persona.email}")

        certificadoSubcollection.get().addOnSuccessListener { result ->
            var pokemonsList = arrayListOf<FireStoreCertificados>()
            for (document in result){
                pokemonsList.add(
                    FireStoreCertificados(
                        document.id.toString(),
                        document.data.get("nombre").toString(),
                        document.data.get("plataforma").toString(),
                        document.data.get("fecha").toString()
                    )
                )
            }

            adapter = ArrayAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                pokemonsList
            )

            binding.lvCertificados.adapter = adapter
            adapter!!.notifyDataSetChanged()

            registerForContextMenu(binding.lvCertificados)

        }

    }
}