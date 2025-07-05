package com.mycompany.e.commercetec;

public class FabricaEntidades {
    
    // Enum para tipos de productos
    public enum TipoProducto {
        FISICO, DIGITAL
    }
    
    // Enum para tipos de usuarios
    public enum TipoUsuario {
        CLIENTE, ADMINISTRADOR
    }
    
    // Factory para crear productos
    public static Producto crearProducto(TipoProducto tipo, int id, String nombre, String descripcion, double precio, int stock, Object... parametrosEspecificos) {
        switch (tipo) {
            case FISICO:
                if (parametrosEspecificos.length >= 2) {
                    double peso = (Double) parametrosEspecificos[0];
                    String dimensiones = (String) parametrosEspecificos[1];
                    return new ProductoFisico(id, nombre, descripcion, precio, stock, peso, dimensiones);
                } else {
                    throw new IllegalArgumentException("ProductoFisico requiere peso y dimensiones");
                }
                
            case DIGITAL:
                if (parametrosEspecificos.length >= 2) {
                    String formato = (String) parametrosEspecificos[0];
                    double tamano = (Double) parametrosEspecificos[1];
                    return new ProductoDigital(id, nombre, descripcion, precio, stock, formato, tamano);
                } else {
                    throw new IllegalArgumentException("ProductoDigital requiere formato y tamaño");
                }
                
            default:
                throw new IllegalArgumentException("Tipo de producto no válido: " + tipo);
        }
    }
    
    // Factory para crear usuarios
    public static Usuario crearUsuario(TipoUsuario tipo, int id, String nombre, String correo, String password) {
        switch (tipo) {
            case CLIENTE:
                return new Cliente(id, nombre, correo, password);
                
            case ADMINISTRADOR:
                return new Administrador(id, nombre, correo, password);
                
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido: " + tipo);
        }
    }
    
    // Método de conveniencia para crear productos físicos
    public static ProductoFisico crearProductoFisico(int id, String nombre, String descripcion, double precio, int stock, double peso, String dimensiones) {
        return (ProductoFisico) crearProducto(TipoProducto.FISICO, id, nombre, descripcion, precio, stock, peso, dimensiones);
    }
    
    // Método de conveniencia para crear productos digitales
    public static ProductoDigital crearProductoDigital(int id, String nombre, String descripcion, double precio, int stock, String formato, double tamano) {
        return (ProductoDigital) crearProducto(TipoProducto.DIGITAL, id, nombre, descripcion, precio, stock, formato, tamano);
    }
    
    // Método de conveniencia para crear clientes
    public static Cliente crearCliente(int id, String nombre, String correo, String password) {
        return (Cliente) crearUsuario(TipoUsuario.CLIENTE, id, nombre, correo, password);
    }
    
    // Método de conveniencia para crear administradores
    public static Administrador crearAdministrador(int id, String nombre, String correo, String password) {
        return (Administrador) crearUsuario(TipoUsuario.ADMINISTRADOR, id, nombre, correo, password);
    }
}
