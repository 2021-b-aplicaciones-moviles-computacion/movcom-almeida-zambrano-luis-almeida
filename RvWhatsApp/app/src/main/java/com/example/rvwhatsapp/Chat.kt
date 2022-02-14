package com.example.rvwhatsapp

data class Chat(
    val nombre_usuario:String,
    val hora_mensaje: String,
    val mensaje: String,
    val cantidad_mensaje: Int,
    val img_url:String
)