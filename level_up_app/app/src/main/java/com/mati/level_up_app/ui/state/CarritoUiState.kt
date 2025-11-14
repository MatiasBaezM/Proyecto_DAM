package com.mati.level_up_app.ui.state

import com.mati.level_up_app.domain.model.Carrito
import com.mati.level_up_app.domain.model.ItemCarrito


data class CarritoUiState(
    val items: List<ItemCarrito> = emptyList(),
    val estaCargando: Boolean = false
) {
    // Calcula el carrito en base a los items
    val carrito: Carrito
        get() = Carrito(items)
}
