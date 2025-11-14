package com.mati.level_up_app.domain.model

data class ErroresFormulario(
    val nombreCompletoError: String? = null,
    val emailError: String? = null,
    val telefonoError: String? = null,
    val direccionError: String? = null,
    val passwordError: String? = null,
    val confirmarPasswordError: String? = null,
    val terminosError: String? = null
) {
    // Verifica si hay algún error
    fun hayErrores(): Boolean {
        return nombreCompletoError != null ||
                emailError != null ||
                telefonoError != null ||
                direccionError != null ||
                passwordError != null ||
                confirmarPasswordError != null ||
                terminosError != null
    }
}
