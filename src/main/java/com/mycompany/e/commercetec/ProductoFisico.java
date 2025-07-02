package com.mycompany.e.commercetec;

public class ProductoFisico extends Producto {
    private double pesoKg;
    private String dimensiones;

    public ProductoFisico(int id, String nombre, String descripcion, double precio, int stock, double pesoKg, String dimensiones) {
        super(id, nombre, descripcion, precio, stock);
        setPesoKg(pesoKg);
        setDimensiones(dimensiones);
    }

    // Getters
    public double getPesoKg() { return pesoKg; }
    public String getDimensiones() { return dimensiones; }

    // Setters con validaciones
    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        } else {
            throw new IllegalArgumentException("El peso debe ser positivo");
        }
    }

    public void setDimensiones(String dimensiones) {
        if (dimensiones != null && !dimensiones.trim().isEmpty()) {
            this.dimensiones = dimensiones.trim();
        } else {
            throw new IllegalArgumentException("Las dimensiones no pueden estar vacías");
        }
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Producto Físico: " + getNombre() + " - $" + getPrecio() +
                " | Peso: " + pesoKg + "kg | Dimensiones: " + dimensiones + " (Stock: " + getStock() + ")");
    }
}