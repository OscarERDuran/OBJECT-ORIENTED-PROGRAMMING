package com.mycompany.e.commercetec;


import java.util.ArrayList;
import java.util.List;

public class GestorInventarioFisico extends GestorInventario {
    private List<ProductoFisico> inventarioFisico;
    
    public GestorInventarioFisico() {
        this.inventarioFisico = new ArrayList<>();
    } 
    
    @Override
    public void añadirProducto(Producto producto) {
        if (producto instanceof ProductoFisico) {
            inventarioFisico.add((ProductoFisico) producto);
            System.out.println("Producto físico agregado: " + producto.getNombre());
        } else {
            throw new IllegalArgumentException("Solo se pueden agregar productos físicos");
        }
    }
    
    @Override
    public boolean eliminarProducto(int id) {
        return inventarioFisico.removeIf(producto -> producto.getId() == id);
    }
    
    @Override
    public void actualizarStock(int id, int nuevoStock) {
        for (ProductoFisico producto : inventarioFisico) {
            if (producto.getId() == id) {
                producto.setStock(nuevoStock);
                System.out.println("Stock actualizado para: " + producto.getNombre());
                return;
            }
        }
        System.out.println("Producto no encontrado con ID: " + id);
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