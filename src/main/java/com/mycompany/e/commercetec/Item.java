package com.mycompany.e.commercetec;

public abstract class Item {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    public Item(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    // Setters con validaciones
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El ID debe ser positivo");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        } else {
            this.descripcion = "";
        }
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    // Método abstracto que deben implementar las clases hijas
    public abstract void mostrarDetalle();
}