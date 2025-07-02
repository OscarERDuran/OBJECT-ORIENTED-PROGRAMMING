package com.mycompany.e.commercetec;

public class Producto extends Item {
    private int stock;

    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        super(id, nombre, descripcion, precio);
        setStock(stock);
    }

    // Getter
    public int getStock() { return stock; }

    // Setter con validación
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Producto: " + getNombre() + " - $" + getPrecio() + " (Stock: " + stock + ")");
    }
}