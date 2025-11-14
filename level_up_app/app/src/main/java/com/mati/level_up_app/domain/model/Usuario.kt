package com.mati.level_up_app.domain.model

data class Usuario(
    val username: String,
    val password: String,
    val rol: Rol = Rol.USUARIO
)

enum class Rol {
    USUARIO,
    ADMIN
}