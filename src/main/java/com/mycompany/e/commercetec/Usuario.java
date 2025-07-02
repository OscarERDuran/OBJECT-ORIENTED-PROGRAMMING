package com.mycompany.e.commercetec;

import java.util.regex.Pattern;

public class Usuario {
    private int id;
    private String nombre;
    private String correoElectronico;
    private String password;

    public Usuario(int id, String nombre, String correoElectronico, String password) {
        setId(id);
        setNombre(nombre);
        setCorreoElectronico(correoElectronico);
        setPassword(password);
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreoElectronico() { return correoElectronico; }

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

    public void setCorreoElectronico(String correoElectronico) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        
        if (correoElectronico != null && pattern.matcher(correoElectronico).matches()) {
            this.correoElectronico = correoElectronico.toLowerCase().trim();
        } else {
            throw new IllegalArgumentException("Formato de correo electrónico inválido");
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }
    }

    // Método para verificar contraseña sin exponer la contraseña real
    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }
}