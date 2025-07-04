package com.mycompany.e.commercetec;


import java.util.ArrayList;
import java.util.List;

public class GestorInventarioDigital extends GestorInventario {
    private List<ProductoDigital> inventarioDigital;
    
    public GestorInventarioDigital() {
        this.inventarioDigital = new ArrayList<>();
    }
    
    @Override
    public void añadirProducto(Producto producto) {
        if (producto instanceof ProductoDigital) {
            inventarioDigital.add((ProductoDigital) producto);
            System.out.println("Producto digital agregado: " + producto.getNombre());
        } else {
            throw new IllegalArgumentException("Solo se pueden agregar productos digitales");
        }
    }
    
    @Override
    public boolean eliminarProducto(int id) {
        return inventarioDigital.removeIf(producto -> producto.getId() == id);
    }
    
    @Override
    public void actualizarStock(int id, int nuevoStock) {
        for (ProductoDigital producto : inventarioDigital) {
            if (producto.getId() == id) {
                producto.setStock(nuevoStock);
                System.out.println("Stock digital actualizado para: " + producto.getNombre());
                return;
            }
        }
        System.out.println("Producto digital no encontrado con ID: " + id);
    }
    
    @Override
    public Producto buscarProducto(int id) {
        return inventarioDigital.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Producto> obtenerInventario() {
        return new ArrayList<>(inventarioDigital);
    }
}
