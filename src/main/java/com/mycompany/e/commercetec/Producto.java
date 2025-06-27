package com.mycompany.e.commercetec;

public class Producto {
    protected int id;
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected int stock;

    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setPrecio(double precio) { this.precio = precio; }

    public void mostrarDetalle() {
        System.out.println("Producto: " + nombre + " - $" + precio);
    }
}