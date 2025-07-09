package com.mycompany.e.commercetec;

import com.mycompany.e.commercetec.exceptions.*;
import java.util.ArrayList;
import java.util.List;

public class GestorInventarioFisico extends GestorInventario {
    private List<ProductoFisico> inventarioFisico;
    
    public GestorInventarioFisico() {
        this.inventarioFisico = new ArrayList<>();
    }
    
    @Override
    public void añadirProducto(Producto producto) throws ECommerceException {
        if (producto == null) {
            throw new ECommerceException("El producto no puede ser nulo", "PRODUCTO_NULO");
        }
        
        if (!(producto instanceof ProductoFisico)) {
            throw new ECommerceException("Solo se pueden agregar productos físicos", "TIPO_PRODUCTO_INCORRECTO");
        }
        
        // Verificar si ya existe
        if (buscarProducto(producto.getId()) != null) {
            throw new ECommerceException("Ya existe un producto con ID: " + producto.getId(), "PRODUCTO_DUPLICADO");
        }
        
        inventarioFisico.add((ProductoFisico) producto);
        System.out.println("Producto físico agregado: " + producto.getNombre());
    }
    
    @Override
    public boolean eliminarProducto(int id) throws ProductoNoEncontradoException {
        ProductoFisico producto = (ProductoFisico) buscarProducto(id);
        if (producto == null) {
            throw new ProductoNoEncontradoException(id);
        }
        
        return inventarioFisico.remove(producto);
    }
    
    @Override
    public void actualizarStock(int id, int nuevoStock) throws ProductoNoEncontradoException, InventarioInsuficienteException {
        if (nuevoStock < 0) {
            throw new InventarioInsuficienteException(id, nuevoStock, 0);
        }
        
        for (ProductoFisico producto : inventarioFisico) {
            if (producto.getId() == id) {
                producto.setStock(nuevoStock);
                System.out.println("Stock actualizado para: " + producto.getNombre());
                return;
            }
        }
        throw new ProductoNoEncontradoException(id);
    }
    
    public void reducirStock(int id, int cantidad) throws ProductoNoEncontradoException, InventarioInsuficienteException {
        ProductoFisico producto = (ProductoFisico) buscarProducto(id);
        if (producto == null) {
            throw new ProductoNoEncontradoException(id);
        }
        
        if (producto.getStock() < cantidad) {
            throw new InventarioInsuficienteException(id, cantidad, producto.getStock());
        }
        
        producto.setStock(producto.getStock() - cantidad);
    }
    
    @Override
    public Producto buscarProducto(int id) {
        return inventarioFisico.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Producto> obtenerInventario() {
        return new ArrayList<>(inventarioFisico);
    }
}