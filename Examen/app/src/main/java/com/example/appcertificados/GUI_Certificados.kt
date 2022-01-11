package com.example.appcertificados

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts

class GUI_Certificados : AppCompatActivity() {

    var idItemSeleccionado = 0
    var idPersonaOwner = 0
    var posPersona = 0

    var list_certificado = arrayListOf<String>()

    var AddNewCertificado = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            if(result.data != null) {
                val data = result.data
                posPersona = data?.getIntExtra("posPersona",0)!!
            }
        }
    }

    var EditarCertificado = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            if(result.data != null) {
                val data = result.data
                posPersona = data?.getIntExtra("posPersona",0)!!
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gui_certificados)
    }



    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "onStart")

        list_certificado = arrayListOf()

        posPersona = intent.getIntExtra("Editar Persona",1)

        Log.i("posEntrendaor","${posPersona}")

        var idCertificado = arrayListOf<Int>()

        val tv_nombre = findViewById<TextView>(R.id.tv_nombre)

        BDMemoria.arr_persona.forEachIndexed{ indice: Int, persona : Persona ->
            Log.i("testExamen","${persona.id_persona} -> ${persona.nombre}")
            if (indice == posPersona){
                idPersonaOwner = persona.id_persona
                var label = "Entrenador: ${persona.nombre}"
                tv_nombre.setText(label)
            }
        }

        BDMemoria.arr_persona_x_certificado.forEachIndexed{ indice: Int, Persona_x_Certificado : Persona_x_Certificado ->
            if (idPersonaOwner == Persona_x_Certificado.id_persona){
                idCertificado.add(Persona_x_Certificado.id_certificado)
            }
        }

        idCertificado.forEach{ idCertificado:Int ->
            BDMemoria.arr_certificado.forEachIndexed{ indice: Int, certificado : Certificado ->
                if (idCertificado == certificado.id_certificado){
                    list_certificado.add(certificado.nombre_curso.toString())
                }
            }
        }

        val lv_certificados = findViewById<ListView>(R.id.lv_certificados)

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            list_certificado
        )
        lv_certificados.adapter = adaptador
        adaptador.notifyDataSetChanged()

        val btn_AddCertificado = findViewById<Button>(R.id.btn_AddCertificado)
        btn_AddCertificado.setOnClickListener {
            //abrirActividadAddPokemon(GUI_AnadirPokemon::class.java)
        }

        val btn_Cancelar = findViewById<Button>(R.id.btn_Cancelar)
        btn_Cancelar.setOnClickListener {
            //val intentAtrasPokemon = Intent(this, GUI_Home::class.java)
            //startActivity(intentAtrasPokemon)
        }

        //BOTON PARA ACTUALIZAR LA LISTA
        //val btnListBD = findViewById<Button>(R.id.btn_ListBD)
        //btnListBD.setOnClickListener {
            //BDMemoria.arr_persona_x_certificado.forEach{PersonaxCertificado: Persona_x_Certificado ->
                //Log.i("More Certificados","${PersonaxCertificado.id_persona} -> ${PersonaxCertificado.id_certificado}")
            //}
        //}

        this.registerForContextMenu(lv_certificados)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.mn_certificado, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        var nombre_curso: String = list_certificado.elementAt(id)
        BDMemoria.arr_certificado.forEach{ certificado: Certificado ->
            if(nombre_curso == certificado.nombre_curso){
                idItemSeleccionado = certificado.id_certificado
            }
        }
        Log.i("idCertificado", "ID ${idItemSeleccionado}")
    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.mn_certificado_editar -> {
//                Log.i("context-menu", "Edit position: ${idItemSeleccionado}")
//                abrirActividadEditarPokemon(GUI_EditarPokemon::class.java)
//                return true
//            }
//            R.id.mi_eliminarPokemon -> {
//                Log.i("context-menu", "Delete position: ${idItemSeleccionado}")
//                eliminarPokemon(idItemSeleccionado)
//                return true
//            }
//            else -> super.onContextItemSelected(item)
//        }
//    }

    fun abrirActividadEditarCertificado(
        clase: Class<*>
    ) {
        val intentEditarCertificado = Intent(this, clase)
        intentEditarCertificado.putExtra("idPersona", idItemSeleccionado)
        intentEditarCertificado.putExtra("posPersona_Edit",posPersona)
        EditarCertificado.launch(intentEditarCertificado)
    }

    fun abrirActividadAddCertificado(
        clase: Class<*>
    ) {
        val intentAddNewCertificado = Intent(this, clase)
        intentAddNewCertificado.putExtra("posicionEntrenador",posPersona)
        Log.i("positionSend","${posPersona}")
        AddNewCertificado.launch(intentAddNewCertificado)
    }

    fun eliminarPokemon(
        idCertificadoAeliminar: Int
    ){
        val  lv_certificados= findViewById<ListView>(R.id.lv_certificados)
        var nombreCertificadoAeliminar = ""

        BDMemoria.arr_certificado.forEach{ certificado: Certificado ->
            if(idCertificadoAeliminar == certificado.id_certificado){
                nombreCertificadoAeliminar = certificado.nombre_curso.toString()
            }
        }

        var list_certificados_restantes = arrayListOf<Persona_x_Certificado>()
        Log.i("idCertificadoAeliminar","${idCertificadoAeliminar}")

        BDMemoria.arr_persona_x_certificado.forEachIndexed{ indice: Int, PersonaxCertificado: Persona_x_Certificado->
            if(!((idCertificadoAeliminar == PersonaxCertificado.id_certificado) and (idPersonaOwner == PersonaxCertificado.id_persona))){
                list_certificados_restantes.add(PersonaxCertificado)
                Log.i("EliminarCertificado","${PersonaxCertificado.id_persona} -> ${PersonaxCertificado.id_certificado}")
            }
        }

        BDMemoria.arr_persona_x_certificado = list_certificados_restantes

        list_certificado.remove(nombreCertificadoAeliminar)

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            list_certificado
        )
        lv_certificados.adapter = adaptador
        adaptador.notifyDataSetChanged()
    }

}