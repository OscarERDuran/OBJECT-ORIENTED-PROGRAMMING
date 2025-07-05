package com.mycompany.e.commercetec;

public class NotificadorInventario implements ObservadorEvento {
    
    @Override
    public void notificar(String evento, Object datos) {
        System.out.println("📦 [INVENTARIO] Procesando evento:");
        System.out.println("   Evento: " + evento);
        
        switch (evento) {
            case "PEDIDO_CREADO":
                actualizarStock(datos);
                break;
            case "STOCK_ACTUALIZADO":
                verificarStockMinimo(datos);
                break;
            case "PRODUCTO_AGREGADO":
                registrarNuevoProducto(datos);
                break;
            default:
                System.out.println("   Evento no relevante para inventario");
        }
    }
    
    private void actualizarStock(Object datos) {
        System.out.println("   ⬇️ Reduciendo stock por venta realizada");
        System.out.println("   📊 Recalculando métricas de inventario");
    }
    
    private void verificarStockMinimo(Object datos) {
        System.out.println("   ⚠️ Verificando si hay productos con stock bajo");
        System.out.println("   📧 Preparando alertas de reabastecimiento si es necesario");
    }
    
    private void registrarNuevoProducto(Object datos) {
        System.out.println("   ✅ Registrando nuevo producto en el sistema de inventario");
    }
}