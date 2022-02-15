package com.example.recyclerwhatsapp

data class Chat(
    val nombre_usuario: String,
    val contenido_mensaje: String,
    val hora_mensaje: String,
    val nuevo_mensaje: Boolean,
    val photo_usuario: String
)