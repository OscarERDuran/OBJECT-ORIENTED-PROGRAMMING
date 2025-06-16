package com.mycompany.e.commercetec;

public class ProductoDigital extends Producto {
    private String formatoArchivo;
    private double tamanoMB;

    public ProductoDigital(int id, String nombre, String descripcion, double precio, int stock, String formatoArchivo, double tamanoMB) {
        super(id, nombre, descripcion, precio, stock);
        this.formatoArchivo = formatoArchivo;
        this.tamanoMB = tamanoMB;
    }

    public String getFormatoArchivo() { return formatoArchivo; }
    public double getTamanoMB() { return tamanoMB; }
}