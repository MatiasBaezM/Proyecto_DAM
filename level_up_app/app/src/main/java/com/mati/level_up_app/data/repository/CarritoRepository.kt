package com.mati.level_up_app.data.repository

import com.mati.level_up_app.data.local.dao.CarritoDao
import com.mati.level_up_app.data.local.entity.CarritoEntity
import com.mati.level_up_app.data.local.entity.toDomain
import com.mati.level_up_app.domain.model.ItemCarrito
import com.mati.level_up_app.domain.model.Producto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class CarritoRepository(private val carritoDao: CarritoDao) {

    /**
     * Obtiene todos los items del carrito como ItemCarrito
     * CAMBIO: Ahora devuelve ItemCarrito con cantidad incluida
     */
    fun obtenerCarrito(): Flow<List<ItemCarrito>> {
        return carritoDao.obtenerTodo()
            .map { entities -> 
                entities.map { entity ->
                    ItemCarrito(
                        producto = entity.toDomain(),
                        cantidad = entity.cantidad
                    )
                }
            }
    }

    /**
     * MEJORADO: Agrega o incrementa la cantidad de un producto
     * 
     * Flujo:
     * 1. Busca si el producto ya existe en el carrito
     * 2. Si existe → suma la cantidad nueva a la existente
     * 3. Si no existe → crea un nuevo registro
     */
    suspend fun agregarProducto(producto: Producto, cantidad: Int = 1) {
        // Paso 1: Buscar si ya existe
        val existente = carritoDao.obtenerPorProductoId(producto.id)
        
        if (existente != null) {
            // Caso A: Ya existe → sumar cantidad
            val nuevaCantidad = existente.cantidad + cantidad
            carritoDao.actualizarCantidad(producto.id, nuevaCantidad)
        } else {
            // Caso B: No existe → insertar nuevo
            val entity = CarritoEntity(
                productoId = producto.id,
                nombre = producto.nombre,
                descripcion = producto.descripcion,
                precio = producto.precio,
                imagenUrl = producto.imagenUrl,
                categoria = producto.categoria,
                stock = producto.stock,
                cantidad = cantidad
            )
            carritoDao.insertar(entity)
        }
    }

    /**
     * NUEVO: Modifica la cantidad de un producto ya en el carrito
     * @param productoId ID del producto
     * @param nuevaCantidad Cantidad a establecer (no suma, reemplaza)
     */
    suspend fun modificarCantidad(productoId: Int, nuevaCantidad: Int) {
        if (nuevaCantidad <= 0) {
            // Si la cantidad es 0 o negativa → eliminar
            eliminarProducto(productoId)
        } else {
            // Actualizar a la nueva cantidad
            carritoDao.actualizarCantidad(productoId, nuevaCantidad)
        }
    }

    /**
     * NUEVO: Elimina un producto específico del carrito
     */
    suspend fun eliminarProducto(productoId: Int) {
        carritoDao.eliminarProducto(productoId)
    }

    /**
     * Vacía el carrito completo
     */
    suspend fun vaciarCarrito() {
        carritoDao.vaciar()
    }

    /**
     * Obtiene el total del carrito
     */
    fun obtenerTotal(): Flow<Double> {
        return carritoDao.obtenerTotal()
            .map { it ?: 0.0 }
    }
}