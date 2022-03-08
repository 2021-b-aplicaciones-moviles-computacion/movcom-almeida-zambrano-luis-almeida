package com.example.proyectoiibim.rvCarrera

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectoiibim.databinding.ItemCarreraBinding

class CarreraViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemCarreraBinding.bind(view)

    fun render(carrera: Carrera, onClickListener: (Carrera) -> Unit) {
        binding.txtNombreCarrera.text = carrera.nombreCarrera
        binding.txtFechaCarrera.text = carrera.fechaCarrera
        binding.txtKmCarrera.text = carrera.distanciaCarrera
        binding.txtNumEtapas.text = carrera.numEtapas
        Glide.with(binding.imgBg.context).load(carrera.imgCarrera).centerCrop().into(binding.imgBg);

        itemView.setOnClickListener {
            onClickListener(carrera)
        }
    }
}