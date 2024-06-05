package com.cfelo.taller_1.model

data class ItemDataModel(
    val titulo: String,
    val fecha: String,
    val estado: Boolean,
    val icono: Int,
    val color: String,
    val descripcion: String?,
    val categoria: String
)
