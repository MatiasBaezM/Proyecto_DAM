package com.mati.level_up_app.ui.navigation


object Rutas {
    const val PORTADA = "portada"
    const val HOME = "home"
    const val DETALLE = "detalle"
    const val CARRITO = "carrito"
    const val REGISTRO = "registro"
    
    // Rutas de administración
    const val LOGIN_ADMIN = "login_admin"
    const val PANEL_ADMIN = "panel_admin"
    const val FORMULARIO_PRODUCTO = "formulario_producto?productoId={productoId}"
    
    // Funciones helper para pasar argumentos
    fun detalleConId(id: Int) = "detalle/$id"
    fun formularioEditar(id: Int) = "formulario_producto?productoId=$id"
}
