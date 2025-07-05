package com.mycompany.e.commercetec;

public class NotificadorUI implements ObservadorEvento {
    private String nombre;
    
    public NotificadorUI(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void notificar(String evento, Object datos) {
        System.out.println("📱 [UI-" + nombre + "] Notificación recibida:");
        System.out.println("   Evento: " + evento);
        System.out.println("   Datos: " + datos);
        
        switch (evento) {
            case "PEDIDO_CREADO":
                mostrarAlertaPedido(datos);
                break;
            case "STOCK_ACTUALIZADO":
                mostrarAlertaStock(datos);
                break;
            case "PAGO_COMPLETADO":
                mostrarAlertaPago(datos);
                break;
            default:
                System.out.println("   Procesando evento en la interfaz...");
        }
    }
    
    private void mostrarAlertaPedido(Object datos) {
        System.out.println("   🛒 Mostrando confirmación de pedido en pantalla");
    }
    
    private void mostrarAlertaStock(Object datos) {
        System.out.println("   📦 Actualizando indicador de stock en pantalla");
    }
    
    private void mostrarAlertaPago(Object datos) {
        System.out.println("   💳 Mostrando confirmación de pago exitoso");
    }
}