package com.mycompany.e.commercetec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    // Getter que devuelve una copia de solo lectura
    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    // Sobrecarga: agregar por objeto
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        } else {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
    }

    // Sobrecarga: agregar por ID (simulación)
    public void agregarProducto(int id) {
        if (id > 0) {
            productos.add(new Producto(id, "ProductoGenérico", "Descripción", 1000, 1));
        } else {
            throw new IllegalArgumentException("El ID debe ser positivo");
        }
    }

    // Sobrecarga: agregar por nombre y precio
    public void agregarProducto(String nombre, double precio) {
        if (nombre != null && !nombre.trim().isEmpty() && precio >= 0) {
            productos.add(new Producto(0, nombre, "Sin descripción", precio, 1));
        } else {
            throw new IllegalArgumentException("Nombre inválido o precio negativo");
        }
    }

    public void removerProducto(Producto producto) {
        productos.remove(producto);
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    public double getTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public int getCantidadProductos() {
        return productos.size();
    }
}