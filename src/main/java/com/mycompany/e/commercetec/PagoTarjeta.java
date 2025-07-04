package com.mycompany.e.commercetec;

import java.util.Random;

public class PagoTarjeta implements ProcesoPago {
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaVencimiento;
    
    public PagoTarjeta(String numeroTarjeta, String nombreTitular, String fechaVencimiento) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    @Override
    public boolean iniciarPago(double monto, String detallesPago) {
        System.out.println("=== PAGO CON TARJETA ===");
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Tarjeta: ****" + numeroTarjeta.substring(numeroTarjeta.length() - 4));
        System.out.println("Monto: $" + monto);
        System.out.println("Detalles: " + detallesPago);
        
        // Simulación de validación de tarjeta
        if (validarTarjeta()) {
            System.out.println("Tarjeta válida. Procesando pago...");
            return true;
        } else {
            System.out.println("Error: Tarjeta inválida o fondos insuficientes");
            return false;
        }
    }
    
    @Override
    public boolean verificarPago(String transactionId) {
        System.out.println("Verificando pago con tarjeta - ID: " + transactionId);
        // Simulación de verificación
        return new Random().nextBoolean();
    }
    
    @Override
    public boolean confirmarPago(String transactionId) {
        System.out.println("Confirmando pago con tarjeta - ID: " + transactionId);
        System.out.println("Pago confirmado exitosamente");
        return true;
    }
    
    @Override
    public void procesarReembolso(String transactionId, double monto) {
        System.out.println("Procesando reembolso a tarjeta");
        System.out.println("ID Transacción: " + transactionId);
        System.out.println("Monto a reembolsar: $" + monto);
        System.out.println("Reembolso procesado. Aparecerá en 3-5 días hábiles");
    }
    
    private boolean validarTarjeta() {
        // Simulación de validación
        return numeroTarjeta.length() == 16 && !fechaVencimiento.isEmpty();
    }
}
