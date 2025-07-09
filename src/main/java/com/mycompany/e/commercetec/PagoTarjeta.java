package com.mycompany.e.commercetec;

import com.mycompany.e.commercetec.exceptions.*;
import java.util.Random;

public class PagoTarjeta implements ProcesoPago {
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaVencimiento;
    
    public PagoTarjeta(String numeroTarjeta, String nombreTitular, String fechaVencimiento) throws TarjetaInvalidaException {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaVencimiento = fechaVencimiento;
        validarTarjeta();
    }
    
    private void validarTarjeta() throws TarjetaInvalidaException {
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            throw new TarjetaInvalidaException(numeroTarjeta, "Número de tarjeta debe tener 16 dígitos");
        }
        
        if (nombreTitular == null || nombreTitular.trim().isEmpty()) {
            throw new TarjetaInvalidaException(numeroTarjeta, "Nombre del titular no puede estar vacío");
        }
        
        if (fechaVencimiento == null || !fechaVencimiento.matches("\\d{2}/\\d{2}")) {
            throw new TarjetaInvalidaException(numeroTarjeta, "Formato de fecha inválido (debe ser MM/YY)");
        }
    }
    
    @Override
    public boolean iniciarPago(double monto, String detallesPago) throws PagoFallidoException {
        String transactionId = "TXN" + System.currentTimeMillis();
        
        if (monto <= 0) {
            throw new PagoFallidoException(transactionId, "Tarjeta", monto, "El monto debe ser positivo");
        }
        
        System.out.println("=== PAGO CON TARJETA ===");
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Tarjeta: ****" + numeroTarjeta.substring(12));
        System.out.println("Monto: $" + monto);
        
        // Simulación de fallas aleatorias
        Random random = new Random();
        if (random.nextInt(10) < 2) { // 20% de probabilidad de falla
            throw new PagoFallidoException(transactionId, "Tarjeta", monto, "Fondos insuficientes");
        }
        
        System.out.println("Pago iniciado exitosamente");
        return true;
    }
    
    @Override
    public boolean verificarPago(String transactionId) throws PagoFallidoException {
        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new PagoFallidoException(transactionId, "Tarjeta", 0.0, "ID de transacción inválido");
        }
        
        System.out.println("Verificando pago con tarjeta - ID: " + transactionId);
        return true;
    }
    
    @Override
    public boolean confirmarPago(String transactionId) throws PagoFallidoException {
        if (!verificarPago(transactionId)) {
            throw new PagoFallidoException(transactionId, "Tarjeta", 0.0, "Verificación de pago falló");
        }
        
        System.out.println("Pago confirmado exitosamente");
        return true;
    }
    
    @Override
    public void procesarReembolso(String transactionId, double monto) throws PagoFallidoException {
        if (monto <= 0) {
            throw new PagoFallidoException(transactionId, "Tarjeta", monto, "Monto de reembolso inválido");
        }
        
        System.out.println("Procesando reembolso: $" + monto);
    }
}