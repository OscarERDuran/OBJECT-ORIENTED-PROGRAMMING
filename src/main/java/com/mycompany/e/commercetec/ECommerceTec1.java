package com.mycompany.e.commercetec;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class ECommerceTec1 {
public static void main(String[] args) {
        // Crear productos
        // Producto producto1 = new Producto(1, "Laptop", "Laptop de alta gama", 1200000,20);
        // Producto producto2 = new Producto(2, "Mouse", "Mouse inalámbrico", 25000, 50);
        // Producto producto3  = new Producto(3 , "Pantalla", "Pantalla LED", 475000, 5);
        // // Crear un usuario
        // Usuario usuario = new Usuario(1, "Oscar Rodriguez", "oscar.rodriguez@example.com", "password123");

        // // Crear un carrito de compras
        // Carrito carrito = new Carrito();

        // // Agregar productos al carrito
        // carrito.agregarProducto(producto1);
        // carrito.agregarProducto(producto2);
        // carrito.agregarProducto(producto3);

        // // Mostrar información del usuario
        // System.out.println("Usuario: " + usuario.getNombre());
        // System.out.println("Correo: " + usuario.getCorreoElectronico());

        // // Mostrar productos en el carrito
        // System.out.println("\nProductos en el carrito:");
        // for (Producto producto : carrito.getProductos()) {
        //     System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
        // }

        // // Mostrar el total del carrito
        // System.out.println("\nTotal del carrito: $" + carrito.getTotal());
    
        
        
        // ==========================
        // Nuevas pruebas con herencia
        // ==========================

        // Productos especializados
        // ProductoFisico fisico = new ProductoFisico(10, "Teclado", "Teclado mecánico", 45000, 20, 0.8, "45x15x3cm");
        // ProductoDigital digital = new ProductoDigital(11, "Curso Java", "Curso online de Java", 99000, 100, "MP4", 1500);

        // // Usuarios especializados
        // Cliente cliente = new Cliente(2, "Ana López", "ana.lopez@example.com", "clave456");
        // Administrador admin = new Administrador(3, "Carlos Admin", "admin@example.com", "adminpass");

        // // Cliente compra productos
        // cliente.agregarCompra(fisico);
        // cliente.agregarCompra(digital);

        // // Admin cambia el precio de un producto físico
        // admin.establecerPromocion(fisico, 39999);

        // // Mostrar información de Cliente
        // System.out.println("\nCliente: " + cliente.getNombre());
        // System.out.println("Historial de compras:");
        // for (Producto p : cliente.getHistorialCompras()) {
        //     System.out.println("- " + p.getNombre() + " ($" + p.getPrecio() + ")");
        // }

        // // Mostrar información de Admin y producto modificado
        // System.out.println("\nAdministrador: " + admin.getNombre());
        // System.out.println("Nuevo precio del producto físico '" + fisico.getNombre() + "': $" + fisico.getPrecio());

        // // Mostrar atributos específicos
        // System.out.println("\nAtributos específicos:");
        // System.out.println("Producto físico - Peso: " + fisico.getPesoKg() + "kg, Dimensiones: " + fisico.getDimensiones());
        // System.out.println("Producto digital - Formato: " + digital.getFormatoArchivo() + ", Tamaño: " + digital.getTamanoMB() + "MB");


      // ==========================
        // Nuevas pruebas con polimorfismo, sobrecarga y sobreescritura
        // ==========================

        ProductoFisico fisico = new ProductoFisico(10, "Teclado", "Teclado mecánico", 45000, 20, 0.8, "45x15x3cm");
        ProductoDigital digital = new ProductoDigital(11, "Curso Java", "Curso online de Java", 99000, 100, "MP4", 1500);

        List<Producto> lista = new ArrayList<>();
        lista.add(fisico);
        lista.add(digital);

        System.out.println("\nDetalles de productos (polimorfismo y sobreescritura):");
        mostrarDetallesProductos(lista);

        Carrito carrito = new Carrito();
        carrito.agregarProducto(fisico); // por objeto
        carrito.agregarProducto(99); // por ID
        carrito.agregarProducto("Audífonos", 15000); // por nombre y precio

        System.out.println("\nProductos en el carrito:");
        for (Producto p : carrito.getProductos()) {
            p.mostrarDetalle();
        }
    }

    // Método polimórfico
    public static void mostrarDetallesProductos(List<Producto> productos) {
        for (Producto p : productos) {
            p.mostrarDetalle();
        }
    }
}


