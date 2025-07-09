package com.mycompany.e.commercetec.exceptions;

public class ProductoNoEncontradoException extends ECommerceException {
    private int productoId;
    
    public ProductoNoEncontradoException(int productoId) {
        super("Producto no encontrado con ID: " + productoId, "PRODUCTO_NO_ENCONTRADO");
        this.productoId = productoId;
    }
    
    public ProductoNoEncontradoException(String nombre) {
        super("Producto no encontrado con nombre: " + nombre, "PRODUCTO_NO_ENCONTRADO");
    }
    
    public int getProductoId() { return productoId; }
}