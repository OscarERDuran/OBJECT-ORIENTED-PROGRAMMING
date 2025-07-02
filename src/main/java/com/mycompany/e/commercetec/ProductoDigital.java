package com.mycompany.e.commercetec;

public class ProductoDigital extends Producto {
    private String formatoArchivo;
    private double tamanoMB;

    public ProductoDigital(int id, String nombre, String descripcion, double precio, int stock, String formatoArchivo, double tamanoMB) {
        super(id, nombre, descripcion, precio, stock);
        setFormatoArchivo(formatoArchivo);
        setTamanoMB(tamanoMB);
    }

    // Getters
    public String getFormatoArchivo() { return formatoArchivo; }
    public double getTamanoMB() { return tamanoMB; }

    // Setters con validaciones
    public void setFormatoArchivo(String formatoArchivo) {
        if (formatoArchivo != null && !formatoArchivo.trim().isEmpty()) {
            this.formatoArchivo = formatoArchivo.trim().toUpperCase();
        } else {
            throw new IllegalArgumentException("El formato de archivo no puede estar vacío");
        }
    }

    public void setTamanoMB(double tamanoMB) {
        if (tamanoMB > 0) {
            this.tamanoMB = tamanoMB;
        } else {
            throw new IllegalArgumentException("El tamaño debe ser positivo");
        }
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Producto Digital: " + getNombre() + " - $" + getPrecio() +
                " | Formato: " + formatoArchivo + " | Tamaño: " + tamanoMB + "MB (Stock: " + getStock() + ")");
    }
}