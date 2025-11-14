package com.mati.level_up_app.domain.repository

import com.mati.level_up_app.domain.model.Producto
import kotlinx.coroutines.flow.Flow

interface RepositorioProductos {
    fun obtenerProductos(): Flow<List<Producto>>
    suspend fun obtenerProductoPorId(id: Int): Producto?
    suspend fun insertarProductos(productos: List<Producto>)
    suspend fun insertarProducto(producto: Producto): Long
    suspend fun eliminarProducto(producto: Producto)
    suspend fun actualizarProducto(producto: Producto)
    suspend fun eliminarTodosLosProductos()
}