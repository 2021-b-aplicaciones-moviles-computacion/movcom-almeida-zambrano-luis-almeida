package com.example.appcertificados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class home_app : AppCompatActivity() {

    // Creamos una variable para ver que item está seleccionado en el ListView
    // Lo inicializamos en la posición 0 por defecto
    var idItemSelected = 0


    // Ciclo de vida cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_app)
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "onStart")

        // Instanciamos la ListView de la GUI
        val lv_personas = findViewById<ListView>(R.id.lv_personas)

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            BDMemoria.arr_persona
        )
        lv_personas.adapter = adaptador
        adaptador.notifyDataSetChanged()
        this.registerForContextMenu(lv_personas)

        // Instanciamos el Boton para añadir una persona
        val btn_AddPersona = findViewById<Button>(R.id.btn_AddCertificado)
        btn_AddPersona.setOnClickListener {
            val intentAddPersona = Intent(this, Add_Persona::class.java)
            startActivity(intentAddPersona)
        }
    }

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
        idItemSelected = id
        Log.i("context-menu", "ID ${id}")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mn_ver -> {
                Log.i("context-menu", "Pokemons: ${idItemSelected}")
                abrirActividadConParametros(GUI_Certificados::class.java)
                return true
            }

//            R.id.mn_certificado_eliminar -> {
//                Log.i("context-menu", "Edit position: ${idItemSelected}")
//                abrirActividadConParametros(GUI_EditarEntrenador::class.java)
//                return true
//            }
//            R.id.mn_eliminar -> {
//                Log.i("context-menu", "Delete position: ${idItemSelected}")
//                eliminarEntrenador(idItemSeleccionado)
//                return true
//            }

            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirActividadConParametros(
        clase: Class<*>
    ) {
        val intentEditarCertificado = Intent(this, clase)
        intentEditarCertificado.putExtra("Pos Editar", idItemSelected)
        startActivity(intentEditarCertificado)
    }
}