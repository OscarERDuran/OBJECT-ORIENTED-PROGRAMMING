package com.mycompany.e.commercetec;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Sobrecarga: agregar por ID (simulación)
    public void agregarProducto(int id) {
        productos.add(new Producto(id, "ProductoGenérico", "Descripción", 1000, 1));
    }

    // Sobrecarga: agregar por nombre y precio
    public void agregarProducto(String nombre, double precio) {
        productos.add(new Producto(0, nombre, "Sin descripción", precio, 1));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
}