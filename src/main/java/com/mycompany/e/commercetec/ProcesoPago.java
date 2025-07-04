package com.mycompany.e.commercetec;

public interface ProcesoPago {
    
    // Métodos que deben implementar todas las clases de pago
    boolean iniciarPago(double monto, String detallesPago);
    boolean verificarPago(String transactionId);
    boolean confirmarPago(String transactionId);
    void procesarReembolso(String transactionId, double monto);
    
    // Método default (opcional de implementar)
    default void mostrarDetallesPago(String transactionId) {
        System.out.println("Procesando detalles para transacción: " + transactionId);
    }
}
