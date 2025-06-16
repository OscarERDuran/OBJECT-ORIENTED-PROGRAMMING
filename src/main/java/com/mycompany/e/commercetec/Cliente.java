package com.mycompany.e.commercetec;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Producto> historialCompras = new ArrayList<>();

    public Cliente(int id, String nombre, String correo, String password) {
        super(id, nombre, correo, password);
    }

    public void agregarCompra(Producto producto) {
        historialCompras.add(producto);
    }

    public List<Producto> getHistorialCompras() {
        return historialCompras;
    }
}