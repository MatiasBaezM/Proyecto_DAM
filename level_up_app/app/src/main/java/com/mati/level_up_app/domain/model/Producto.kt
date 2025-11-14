package com.mati.level_up_app.domain.model

data class Producto (
    val id: Int = 0,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val imagenUrl: String,
    val categoria: String,
    val stock: Int
)
{
    fun precioFormateado(): String {
        val precioEntero = precio.toInt()
        return "$$${precioEntero.toString().reversed().chunked(3).joinToString(".").reversed()}"
    }

    val hayStock: Boolean
        get() = stock>0

}