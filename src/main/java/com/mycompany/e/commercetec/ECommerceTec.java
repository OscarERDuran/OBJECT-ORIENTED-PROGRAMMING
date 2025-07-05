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

    

         // =================================
        // PRUEBAS DE PATRONES DE DISEÑO
        // =================================
        
        System.out.println("\n=== PATRÓN SINGLETON ===");
        demostracionSingleton();
        
        System.out.println("\n=== PATRÓN FACTORY ===");
        demostracionFactory();
        
        System.out.println("\n=== PATRÓN OBSERVER ===");
        demostracionObserver();
    }
    
    // Demostración del patrón Singleton
    private static void demostracionSingleton() {
        // Obtener la misma instancia desde diferentes lugares
        ConfiguracionSistema config1 = ConfiguracionSistema.obtenerInstancia();
        ConfiguracionSistema config2 = ConfiguracionSistema.obtenerInstancia();
        
        // Verificar que es la misma instancia
        System.out.println("¿Es la misma instancia? " + (config1 == config2));
        
        // Mostrar configuraciones por defecto
        config1.mostrarConfiguraciones();
        
        // Modificar configuración
        config1.establecerConfiguracion("ui.tema", "claro");
        config1.establecerConfiguracion("inventario.alertaStock", "10");
        
        // Verificar que los cambios se reflejan en la segunda referencia
        System.out.println("Tema desde config2: " + config2.obtenerConfiguracion("ui.tema"));
    }
    
    // Demostración del patrón Factory
    private static void demostracionFactory() {
        System.out.println("Creando entidades usando Factory Pattern:");
        
        // Crear productos usando la fábrica
        Producto laptop = FabricaEntidades.crearProductoFisico(
            1, "Laptop Gaming", "Laptop de alta gama", 2500000, 5, 3.2, "40x30x5cm"
        );
        
        Producto curso = FabricaEntidades.crearProductoDigital(
            2, "Curso Python", "Curso completo de Python", 200000, 100, "MP4", 1500
        );
        
        // Crear usuarios usando la fábrica
        Usuario cliente = FabricaEntidades.crearCliente(
            1, "Ana López", "ana@email.com", "password123"
        );
        
        Usuario admin = FabricaEntidades.crearAdministrador(
            2, "Carlos Admin", "admin@email.com", "adminpass"
        );
        
        // Mostrar las entidades creadas
        laptop.mostrarDetalle();
        curso.mostrarDetalle();
        System.out.println("Cliente creado: " + cliente.getNombre());
        System.out.println("Administrador creado: " + admin.getNombre());
    }
    
    // Demostración del patrón Observer
    private static void demostracionObserver() {
        // Crear el gestor de eventos
        GestorEventos gestorEventos = new GestorEventos();
        
        // Crear observadores
        NotificadorUI notificadorUI = new NotificadorUI("Principal");
        NotificadorInventario notificadorInventario = new NotificadorInventario();
        NotificadorEmail notificadorEmail = new NotificadorEmail();
        
        // Suscribir observadores al gestor de eventos
        gestorEventos.suscribir(notificadorUI);
        gestorEventos.suscribir(notificadorInventario);
        gestorEventos.suscribir(notificadorEmail);
        
        // Simular eventos del sistema
        System.out.println("\n--- Simulando creación de pedido ---");
        gestorEventos.notificarEvento("PEDIDO_CREADO", "Pedido #12345 - Cliente: Ana López");
        
        System.out.println("\n--- Simulando actualización de stock ---");
        gestorEventos.notificarEvento("STOCK_ACTUALIZADO", "Producto: Laptop - Nuevo stock: 3");
        
        System.out.println("\n--- Simulando pago completado ---");
        gestorEventos.notificarEvento("PAGO_COMPLETADO", "Transacción: TXN789 - Monto: $2,700,000");
        
        // Desuscribir un observador
        System.out.println("\n--- Desuscribiendo notificador UI ---");
        gestorEventos.desuscribir(notificadorUI);
        
        System.out.println("\n--- Simulando evento después de desuscripción ---");
        gestorEventos.notificarEvento("STOCK_BAJO", "Producto: Laptop - Stock restante: 2");
    
    }
}

