package com.example.proyectoiibim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoiibim.databinding.ActivityHomeAppBinding
import com.example.proyectoiibim.rvCarrera.Carrera
import com.example.proyectoiibim.rvCarrera.CarreraAdapter
import com.example.proyectoiibim.rvCarrera.CarreraProvider
import com.google.firebase.firestore.*

class HomeApp : AppCompatActivity() {


    private lateinit var binding: ActivityHomeAppBinding
    private val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCarreras.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        binding.rvCarreras.adapter =
            CarreraAdapter(CarreraProvider.carreraList) { carrera -> onItemSelected(carrera) }

        eventCargarCarreras()
    }

    fun eventCargarCarreras() {
        CarreraProvider.carreraList.clear()
        db.collection("carreras")
            .whereEqualTo("actual", true)
            .addSnapshotListener(
                object : EventListener<QuerySnapshot> {
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error != null) {
                            Log.e("FireStore-Error", error.message.toString())
                            return
                        }
                        for (de: DocumentChange in value?.documentChanges!!) {
                            if (de.type == DocumentChange.Type.ADDED) {
                                CarreraProvider.carreraList.add(
                                    Carrera(
                                        de.document.data["imgUrl"].toString(),
                                        de.document.data["nombre"].toString(),
                                        de.document.data["fecha"].toString(),
                                        de.document.data["distancia"].toString(),
                                        de.document.data["etapas"].toString(),
                                        de.document.data["actual"].toString(),
                                    )
                                )
                                Log.w("Data", "--->${CarreraProvider.carreraList}")
                            }
                            CarreraAdapter(CarreraProvider.carreraList){ carrera ->
                                onItemSelected(carrera)
                            }.notifyDataSetChanged()
                            Log.w("Data", "${de.document["nombre"]}")
                        }
                        binding.rvCarreras.adapter =
                            CarreraAdapter(CarreraProvider.carreraList) { carrera ->
                                onItemSelected(carrera)
                            }
                    }
                }
            )


    }

    fun onItemSelected(carrera: Carrera) {
        val intent = Intent(this, ViewCarrera::class.java)
        startActivity(intent)

    }


}