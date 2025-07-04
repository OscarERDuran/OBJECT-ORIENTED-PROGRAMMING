package com.mycompany.e.commercetec;

public class ECommerceTec {

    public static void main(String[] args) {

        // PRUEBAS DE Encapsulamiento Y abstracción
    //     try {
    //         // Ejemplos de encapsulamiento y validaciones
    //         System.out.println("=== Pruebas de Encapsulamiento y Validaciones ===");
            
    //         // Crear productos con validaciones
    //         ProductoFisico fisico = new ProductoFisico(1, "Laptop", "Laptop", 1500000, 10, 2.5, "35x25x3cm");
    //         ProductoDigital digital = new ProductoDigital(2, "Curso", "Curso completo", 150000, 100, "MP4", 2048);
            
    //         // Crear usuario con validaciones
    //         Usuario usuario = new Usuario(1, "Juan Pérez", "juan.perez@email.com", "password123");
            
    //         // Crear carrito
    //         Carrito carrito = new Carrito();
    //         carrito.agregarProducto(fisico);
    //         carrito.agregarProducto(digital);
            
    //         // Mostrar información usando polimorfismo
    //         System.out.println("\nProductos en el carrito:");
    //         mostrarDetallesProductos(carrito.getProductos());
            
    //         System.out.println("\nTotal del carrito: $" + carrito.getTotal());
            
    //         // Probar validaciones (estas líneas causarán excepciones)
    //         System.out.println("\n=== Pruebas de Validaciones ===");
            
    //         // Precio negativo (causará excepción)
    //         // fisico.setPrecio(-100);
            
    //         // Email inválido (causará excepción)
    //         //usuario.setCorreoElectronico("email-invalido");

    //         System.out.println("Todas las validaciones funcionan correctamente!");
            
    //     } catch (IllegalArgumentException e) {
    //         System.err.println("Error de validación: " + e.getMessage());
    //     }
    // }

    // // Método polimórfico usando abstracción
    // public static void mostrarDetallesProductos(List<? extends Item> productos) {
    //     for (Item p : productos) {
    //         p.mostrarDetalle();
    //     }



    
// =================================
        // PRUEBAS DE INTERFACES Y CLASES ABSTRACTAS
        // =================================
        
        System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
        
        // Crear gestores de inventario
        GestorInventario gestorFisico = new GestorInventarioFisico();
        GestorInventario gestorDigital = new GestorInventarioDigital();
        
        // Crear productos
        ProductoFisico laptop = new ProductoFisico(1, "Laptop", "Laptop gaming", 1500000, 5, 2.5, "35x25x3cm");
        ProductoDigital curso = new ProductoDigital(2, "Curso Java", "Curso completo", 150000, 100, "MP4", 2048);
        
        // Gestionar inventario físico
        gestorFisico.añadirProducto(laptop);
        gestorFisico.actualizarStock(1, 3);
        gestorFisico.mostrarInventario();
        
        // Gestionar inventario digital
        gestorDigital.añadirProducto(curso);
        gestorDigital.actualizarStock(2, 150);
        gestorDigital.mostrarInventario();
        
        System.out.println("\n=== PROCESOS DE PAGO ===");
        
        // Crear métodos de pago
        ProcesoPago pagoTarjeta = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
        ProcesoPago pagoPayPal = new PagoPayPal("juan.perez@email.com", "password123");
        
        double montoTotal = 1650000; // laptop + curso
        String transactionId = "TXN" + System.currentTimeMillis();
        
        // Procesar pago con tarjeta
        if (pagoTarjeta.iniciarPago(montoTotal, "Compra de laptop y curso")) {
            if (pagoTarjeta.verificarPago(transactionId)) {
                pagoTarjeta.confirmarPago(transactionId);
            }
        }
        
        System.out.println();
        
        // Procesar pago con PayPal
        if (pagoPayPal.iniciarPago(montoTotal, "Compra de laptop y curso")) {
            if (pagoPayPal.verificarPago(transactionId)) {
                pagoPayPal.confirmarPago(transactionId);
                pagoPayPal.mostrarDetallesPago(transactionId);
            }
        }

    }
}

