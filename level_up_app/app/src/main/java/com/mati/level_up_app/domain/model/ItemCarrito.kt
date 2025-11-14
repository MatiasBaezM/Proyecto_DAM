package com.mati.level_up_app.domain.model

import kotlin.times

data class ItemCarrito(
    val producto: Producto,
    val cantidad: Int = 1
) {
    // Propiedad calculada: subtotal del item
    val subtotal: Double
        get() = producto.precio * cantidad
}