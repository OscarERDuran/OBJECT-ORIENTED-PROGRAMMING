
package com.mycompany.e.commercetec;

/**
 *
 * @author Admin
 */
// Clase Carrito

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private double total;

    // Constructor
    public Carrito() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    // Método para añadir un producto al carrito
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        calcularTotal();
    }

    // Método para remover un producto del carrito
    public void removerProducto(Producto producto) {
        productos.remove(producto);
        calcularTotal();
    }

    // Método para calcular el total del carrito
    private void calcularTotal() {
        total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
    }

    // Método para obtener el total
    public double getTotal() {
        return total;
    }

    // Método para obtener la lista de productos
    public List<Producto> getProductos() {
        return productos;
    }
}