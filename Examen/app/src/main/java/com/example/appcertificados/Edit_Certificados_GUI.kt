package com.example.appcertificados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class Edit_Certificados_GUI : AppCompatActivity() {

    var posPersona=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_certificados_gui)
    }

    override fun onStart() {
        Log.i("ciclo-vida", "onStart")
        super.onStart()

        val idCertificado = intent.getIntExtra("idPersona",1)
        posPersona = intent.getIntExtra("posPersona_Edit",1)

        val ti_nombre_certificado = findViewById<TextInputEditText>(R.id.ti_nombre_certificado)
        val ti_nombre_plataforma = findViewById<TextInputEditText>(R.id.ti_nombre_plataforma)
        val ti_fecha_certificado = findViewById<TextInputEditText>(R.id.ti_fecha_certificado)

        BDMemoria.arr_certificado.forEachIndexed{ indice: Int, certificado : Certificado ->
            if (idCertificado == certificado.id_certificado){
                ti_nombre_certificado.setText(certificado.nombre_curso)
                ti_nombre_plataforma.setText(certificado.nombre_plataforma)
                ti_fecha_certificado.setText(certificado.fecha)
            }
        }

        val btn_Editar = findViewById<Button>(R.id.btn_AddCertificado)
        btn_Editar.setOnClickListener {
            BDMemoria.arr_certificado.forEachIndexed{ indice: Int, certificado: Certificado ->
                if (idCertificado == certificado.id_certificado){
                    Log.i("editar","${ti_nombre_certificado.text.toString()}")
                    certificado.nombre_curso = (ti_nombre_certificado.text.toString())
                    certificado.nombre_plataforma = (ti_nombre_plataforma.text.toString())
                    certificado.fecha = (ti_fecha_certificado.text.toString())
                }
            }
            respuesta()
        }

        val btn_Cancelar = findViewById<Button>(R.id.btn_Cancelar)
        btn_Cancelar.setOnClickListener{
            respuesta()
        }
    }

    fun respuesta(){
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("posPersona_Edit",posPersona)
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }
}