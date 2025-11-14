package com.mati.level_up_app.ui.state

import com.mati.level_up_app.domain.model.Producto


data class ProductoUiState(
    val estaCargando: Boolean = false,
    val productos: List<Producto> = emptyList(),
    val error: String? = null
) {
    // Helper: verifica si hay productos
    val hayProductos: Boolean
        get() = productos.isNotEmpty()
}
