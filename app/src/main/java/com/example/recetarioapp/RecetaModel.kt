package com.example.recetarioapp

data class RecetaModel(
    val tipo: Int,
    val nombre: String,
    val descripcion: String,
    val ingredientes: String,
    val preparacion: String,
    val video: String
)