package com.mycompany.e.commercetec;

import java.util.List;

import com.mycompany.e.commercetec.exceptions.ECommerceException;
import com.mycompany.e.commercetec.exceptions.InventarioInsuficienteException;
import com.mycompany.e.commercetec.exceptions.ProductoNoEncontradoException;

public abstract class GestorInventario {
    
    // Métodos abstractos que deben implementar las clases hijas
    // ← AGREGADAS LAS EXCEPCIONES NECESARIAS
    public abstract void añadirProducto(Producto producto) throws ECommerceException;
    
    public abstract boolean eliminarProducto(int id) throws ProductoNoEncontradoException;
    
    public abstract void actualizarStock(int id, int nuevoStock) throws ProductoNoEncontradoException, InventarioInsuficienteException;
    
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
    
    // ← MÉTODO ADICIONAL: Para validar stock mínimo
    protected void validarStockMinimo(int stock, int minimo) throws InventarioInsuficienteException {
        if (stock < minimo) {
            throw new InventarioInsuficienteException(-1, minimo, stock);
        }
    }
    
    // ← MÉTODO ADICIONAL: Para mostrar resumen de inventario
    public void mostrarResumen() {
        List<Producto> productos = obtenerInventario();
        int totalProductos = productos.size();
        int stockTotal = productos.stream()
                .mapToInt(Producto::getStock)
                .sum();
        double valorTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();
        
        System.out.println("=== RESUMEN DE INVENTARIO ===");
        System.out.println("Total de productos: " + totalProductos);
        System.out.println("Stock total: " + stockTotal + " unidades");
        System.out.println("Valor total: $" + String.format("%.2f", valorTotal));
        System.out.println("=============================");
    }
}