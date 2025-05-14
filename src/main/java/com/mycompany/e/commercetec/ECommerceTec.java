
package com.mycompany.e.commercetec;

/**
 *
 * @author Admin
 */
public class ECommerceTec {
public static void main(String[] args) {
        // Crear productos
        Producto producto1 = new Producto(1, "Laptop", "Laptop de alta gama", 1200000,20);
        Producto producto2 = new Producto(2, "Mouse", "Mouse inalámbrico", 25000, 50);
        Producto producto3  = new Producto(3 , "Pantalla", "Pantalla LED", 475000, 5);
        // Crear un usuario
        Usuario usuario = new Usuario(1, "Oscar Rodriguez", "oscar.rodriguez@example.com", "password123");

        // Crear un carrito de compras
        Carrito carrito = new Carrito();

        // Agregar productos al carrito
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);

        // Mostrar información del usuario
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreoElectronico());

        // Mostrar productos en el carrito
        System.out.println("\nProductos en el carrito:");
        for (Producto producto : carrito.getProductos()) {
            System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
        }

        // Mostrar el total del carrito
        System.out.println("\nTotal del carrito: $" + carrito.getTotal());
    }
}
