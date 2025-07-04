package com.mycompany.e.commercetec;

import java.util.List;

public abstract class GestorInventario {
    
    // Métodos abstractos que deben implementar las clases hijas
    public abstract void añadirProducto(Producto producto);
    public abstract boolean eliminarProducto(int id);
    public abstract void actualizarStock(int id, int nuevoStock);
    public abstract Producto buscarProducto(int id);
    public abstract List<Producto> obtenerInventario();
    
    // Método concreto que pueden usar todas las implementaciones
    public void mostrarInventario() {
        System.out.println("=== INVENTARIO ===");
        List<Producto> productos = obtenerInventario();
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario");
        } else {
            for (Producto producto : productos) {
                producto.mostrarDetalle();
            }
        }
        System.out.println("==================");
    }
}
