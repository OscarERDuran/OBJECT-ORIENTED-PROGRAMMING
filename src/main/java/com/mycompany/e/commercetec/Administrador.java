package com.mycompany.e.commercetec;

public class Administrador extends Usuario {
    public Administrador(int id, String nombre, String correo, String password) {
        super(id, nombre, correo, password);
    }

    public void gestionarInventario() {
        // Lógica para gestionar inventario
    }

    public void establecerPromocion(Producto producto, double nuevoPrecio) {
        producto.setPrecio(nuevoPrecio);
    }
}