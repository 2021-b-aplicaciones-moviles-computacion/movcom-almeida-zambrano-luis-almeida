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
import androidx.core.view.updatePadding

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

        posPersona = intent.getIntExtra("posEditar",1)

        Log.i("posPersona","${posPersona}")

        var idCertificado = arrayListOf<Int>()

        val tv_nombre = findViewById<TextView>(R.id.tv_nombre)

        BDMemoria.arr_persona.forEachIndexed{ indice: Int, persona : Persona ->
            Log.i("testExamen","${persona.id_persona} -> ${persona.nombre}")
            if (indice == posPersona){
                idPersonaOwner = persona.id_persona
                var label = "Persona: ${persona.nombre}"
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

        val btn_Reload = findViewById<Button>(R.id.btn_Reload)

        val btn_AddCertificado = findViewById<Button>(R.id.btn_AddCertificado)
        btn_AddCertificado.setOnClickListener {
            abrirActividadAddCertificado(Gui_AddCertificado::class.java)
            btn_Reload.setVisibility(View.VISIBLE);
        }

        val btn_Cancelar = findViewById<Button>(R.id.btn_Cancelar)
        btn_Cancelar.setOnClickListener {
            val intent = Intent(this, home_app::class.java)
            btn_Reload.setVisibility(View.INVISIBLE);
            startActivity(intent)
        }



        //BOTON PARA ACTUALIZAR LA LISTA
        btn_Reload.setOnClickListener {
            BDMemoria.arr_persona_x_certificado.forEach{PersonaxCertificado: Persona_x_Certificado ->
                Log.i("More Certificados","${PersonaxCertificado.id_persona} -> ${PersonaxCertificado.id_certificado}")
            }
        }

        this.registerForContextMenu(lv_certificados)
        lv_certificados.updatePadding(left = 40)
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

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mn_certificado_editar -> {
                Log.i("context-menu", "Edit position: ${idItemSeleccionado}")
                abrirActividadEditarCertificado(Edit_Certificados_GUI::class.java)
                return true
            }
            R.id.mn_certificado_eliminar -> {
                Log.i("context-menu", "Delete position: ${idItemSeleccionado}")
                eliminarCertificado(idItemSeleccionado)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

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
        intentAddNewCertificado.putExtra("posPersona",posPersona)
        Log.i("positionSend","${posPersona}")
        AddNewCertificado.launch(intentAddNewCertificado)
    }

    fun eliminarCertificado(
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