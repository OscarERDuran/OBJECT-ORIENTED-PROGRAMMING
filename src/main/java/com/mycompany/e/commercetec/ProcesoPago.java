package com.mycompany.e.commercetec;

import com.mycompany.e.commercetec.exceptions.PagoFallidoException;

public interface ProcesoPago {
    
    // Métodos que deben implementar todas las clases de pago
    // ← AGREGADAS LAS EXCEPCIONES NECESARIAS
    boolean iniciarPago(double monto, String detallesPago) throws PagoFallidoException;
    
    boolean verificarPago(String transactionId) throws PagoFallidoException;
    
    boolean confirmarPago(String transactionId) throws PagoFallidoException;
    
    void procesarReembolso(String transactionId, double monto) throws PagoFallidoException;
    
    // Método default (opcional de implementar)
    default void mostrarDetallesPago(String transactionId) {
        System.out.println("=== DETALLES DE PAGO ===");
        System.out.println("ID Transacción: " + transactionId);
        System.out.println("Estado: Procesado");
        System.out.println("========================");
    }
    
    // ← MÉTODO ADICIONAL: Para obtener el tipo de pago
    default String obtenerTipoPago() {
        return "Método de pago genérico";
    }
    
    // ← MÉTODO ADICIONAL: Para validar monto
    default void validarMonto(double monto) throws PagoFallidoException {
        if (monto <= 0) {
            throw new PagoFallidoException("INVALID", "Genérico", monto, "El monto debe ser positivo");
        }
        if (monto > 10000000) { // Límite de 10 millones
            throw new PagoFallidoException("LIMIT_EXCEEDED", "Genérico", monto, "Monto excede el límite permitido");
        }
    }
}