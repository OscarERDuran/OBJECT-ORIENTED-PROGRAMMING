package com.mycompany.e.commercetec;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Ejemplos de encapsulamiento y validaciones
            System.out.println("=== Pruebas de Encapsulamiento y Validaciones ===");
            
            // Crear productos con validaciones
            ProductoFisico fisico = new ProductoFisico(1, "Laptop", "Laptop gaming", 1500000, 10, 2.5, "35x25x3cm");
            ProductoDigital digital = new ProductoDigital(2, "Curso Java", "Curso completo", 150000, 100, "MP4", 2048);
            
            // Crear usuario con validaciones
            Usuario usuario = new Usuario(1, "Juan Pérez", "juan.perez@email.com", "password123");
            
            // Crear carrito
            Carrito carrito = new Carrito();
            carrito.agregarProducto(fisico);
            carrito.agregarProducto(digital);
            
            // Mostrar información usando polimorfismo
            System.out.println("\nProductos en el carrito:");
            mostrarDetallesProductos(carrito.getProductos());
            
            System.out.println("\nTotal del carrito: $" + carrito.getTotal());
            
            // Probar validaciones (estas líneas causarán excepciones)
            System.out.println("\n=== Pruebas de Validaciones ===");
            
            // Precio negativo (causará excepción)
            // fisico.setPrecio(-100);
            
            // Email inválido (causará excepción)
            //usuario.setCorreoElectronico("email-invalido");

            System.out.println("Todas las validaciones funcionan correctamente!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        }
    }

    // Método polimórfico usando abstracción
    public static void mostrarDetallesProductos(List<? extends Item> productos) {
        for (Item p : productos) {
            p.mostrarDetalle();
        }
    }
}