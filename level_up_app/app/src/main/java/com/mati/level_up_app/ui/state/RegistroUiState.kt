package com.mati.level_up_app.ui.state

import com.mati.level_up_app.domain.model.ErroresFormulario
import com.mati.level_up_app.domain.model.FormularioRegistro


data class RegistroUiState(
    val formulario: FormularioRegistro = FormularioRegistro(),
    val errores: ErroresFormulario = ErroresFormulario(),
    val estaGuardando: Boolean = false,
    val registroExitoso: Boolean = false
)
