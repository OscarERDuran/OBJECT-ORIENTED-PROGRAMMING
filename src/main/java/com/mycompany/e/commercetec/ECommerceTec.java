package com.mycompany.e.commercetec;

import com.mycompany.e.commercetec.exceptions.ECommerceException;
import com.mycompany.e.commercetec.exceptions.InventarioInsuficienteException;
import com.mycompany.e.commercetec.exceptions.PagoFallidoException;
import com.mycompany.e.commercetec.exceptions.TarjetaInvalidaException;

public class ECommerceTec {
    public static void main(String[] args) {
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
        try {
            gestorFisico.añadirProducto(laptop); // ← CORREGIDO: sin espacio
            gestorFisico.actualizarStock(1, 3);
            gestorFisico.mostrarInventario();
        } catch (ECommerceException e) {
            System.err.println("Error en inventario físico: " + e.getMessage());
        }
        
        // Gestionar inventario digital
        try {
            gestorDigital.añadirProducto(curso);
            gestorDigital.actualizarStock(2, 150);
            gestorDigital.mostrarInventario();
        } catch (ECommerceException e) {
            System.err.println("Error en inventario  digital: " + e.getMessage());
        }
        
        System.out.println("\n=== PROCESOS DE PAGO ===");
        
        try {
            // Crear métodos de pago
            ProcesoPago pagoTarjeta = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
            ProcesoPago pagoPayPal = new PagoPayPal("juan.perez@email.com", "password123");
            
            double montoTotal = 1650000; // laptop + curso
            String transactionId = "TXN" + System.currentTimeMillis();
            
            // Procesar pago con tarjeta
            if (pagoTarjeta.iniciarPago(montoTotal, "Compra de laptop y curso")) {
                if (pagoTarjeta.verificarPago(transactionId)) { // ← CORREGIDO
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
        } catch (PagoFallidoException e) {
            System.err.println("Error en procesos de pago: " + e.getMessage());
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
        
        // =================================
        // PRUEBAS DE MANEJO DE EXCEPCIONES
        // =================================
        
        System.out.println("\n=== MANEJO DE EXCEPCIONES ===");
        demostracionExcepciones();
        
    } // ← AQUÍ termina el método main()
    
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
    
    private static void demostracionExcepciones() {
        System.out.println("Demostrando manejo de excepciones personalizadas:");
        
        // 1. Excepciones de inventario
        try {
            GestorInventarioFisico gestor = new GestorInventarioFisico();
            ProductoFisico laptop = new ProductoFisico(1, "Laptop", "Laptop gaming", 1500000, 5, 2.5, "30x20x5");
            
            gestor.añadirProducto(laptop);
            System.out.println("✅ Producto agregado exitosamente");
            
            // Intentar reducir más stock del disponible
            gestor.reducirStock(1, 10); // Falla: solo hay 5 en stock
            
        } catch (InventarioInsuficienteException e) {
            System.err.println("❌ Error de inventario: " + e.getMessage());
            System.err.println("   Stock disponible: " + e.getStockDisponible());
            System.err.println("   Stock solicitado: " + e.getStockSolicitado());
        } catch (ECommerceException e) {
            System.err.println("❌ Error general: " + e.getMessage());
            System.err.println("   Código: " + e.getCodigoError());
        }
        
        // 2. Excepciones de pago
        try {
            // Crear tarjeta inválida
            PagoTarjeta pagoInvalido = new PagoTarjeta("123", "Juan", "invalid");
            
        } catch (TarjetaInvalidaException e) {
            System.err.println("❌ Error de tarjeta: " + e.getMessage());
            System.err.println("   Número de tarjeta: " + e.getNumeroTarjeta());
        }
        
        try {
            // Crear tarjeta válida pero pago con monto inválido
            PagoTarjeta pagoValido = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
            pagoValido.iniciarPago(-100, "Compra inválida");
            
        } catch (TarjetaInvalidaException e) {
            System.err.println("❌ Error de tarjeta: " + e.getMessage());
        } catch (PagoFallidoException e) {
            System.err.println("❌ Error de pago: " + e.getMessage());
            System.err.println("   Transaction ID: " + e.getTransactionId());
            System.err.println("   Método: " + e.getMetodoPago());
            System.err.println("   Monto: $" + e.getMonto());
        }
        
        // 3. Recuperación graciosa
        System.out.println("\n--- Demostración de recuperación graciosa ---");
        try {
            GestorInventarioFisico gestor = new GestorInventarioFisico();
            ProductoFisico producto = new ProductoFisico(1, "Mouse", "Mouse gaming", 50000, 3, 0.2, "10x5x3");
            
            gestor.añadirProducto(producto);
            
            // Intentar vender 5 unidades cuando solo hay 3
            int cantidadSolicitada = 5;
            gestor.reducirStock(1, cantidadSolicitada);
            
        } catch (InventarioInsuficienteException e) {
            System.out.println("⚠️ Stock insuficiente, ajustando pedido...");
            System.out.println("   Cantidad máxima disponible: " + e.getStockDisponible());
            System.out.println("   Procediendo con la cantidad disponible");
            
            // Recuperación: vender solo lo disponible
            try {
                GestorInventarioFisico gestor = new GestorInventarioFisico();
                ProductoFisico producto = new ProductoFisico(1, "Mouse", "Mouse gaming", 50000, 3, 0.2, "10x5x3");
                gestor.añadirProducto(producto);
                gestor.reducirStock(1, e.getStockDisponible());
                System.out.println("✅ Venta procesada con cantidad ajustada");
                
            } catch (ECommerceException ex) {
                System.err.println("❌ Error en recuperación: " + ex.getMessage());
            }
        } catch (ECommerceException e) {
            System.err.println("❌ Error general: " + e.getMessage());
        }
    }
    
} 