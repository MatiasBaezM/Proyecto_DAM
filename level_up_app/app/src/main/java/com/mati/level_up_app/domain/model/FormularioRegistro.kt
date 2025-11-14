package com.mati.level_up_app.domain.model

data class FormularioRegistro(
    val nombreCompleto: String = "",
    val email: String = "",
    val telefono: String = "",
    val direccion: String = "",
    val password: String = "",
    val confirmarPassword: String = "",
    val aceptaTerminos: Boolean = false
)
