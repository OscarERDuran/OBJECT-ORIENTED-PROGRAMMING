package com.mycompany.e.commercetec;

public class NotificadorEmail implements ObservadorEvento {
    
    @Override
    public void notificar(String evento, Object datos) {
        System.out.println("📧 [EMAIL] Procesando notificación:");
        
        switch (evento) {
            case "PEDIDO_CREADO":
                enviarConfirmacionPedido(datos);
                break;
            case "PAGO_COMPLETADO":
                enviarConfirmacionPago(datos);
                break;
            case "STOCK_BAJO":
                enviarAlertaStock(datos);
                break;
            default:
                System.out.println("   No se requiere email para este evento");
        }
    }
    
    private void enviarConfirmacionPedido(Object datos) {
        System.out.println("   📮 Enviando email de confirmación de pedido al cliente");
        System.out.println("   📄 Incluyendo detalles del pedido y tiempo estimado de entrega");
    }
    
    private void enviarConfirmacionPago(Object datos) {
        System.out.println("   💌 Enviando comprobante de pago por email");
        System.out.println("   🧾 Adjuntando factura digital");
    }
    
    private void enviarAlertaStock(Object datos) {
        System.out.println("   ⚠️ Enviando alerta de stock bajo al administrador");
        System.out.println("   📊 Incluyendo reporte de productos afectados");
    }
}