package com.mycompany.e.commercetec.exceptions;

public class PagoFallidoException extends ECommerceException {
    private String transactionId;
    private String metodoPago;
    private double monto;
    
    public PagoFallidoException(String transactionId, String metodoPago, double monto, String razon) {
        super(String.format("Pago fallido - ID: %s, Método: %s, Monto: $%.2f. Razón: %s", 
              transactionId, metodoPago, monto, razon), "PAGO_FALLIDO");
        this.transactionId = transactionId;
        this.metodoPago = metodoPago;
        this.monto = monto;
    }
    
    public String getTransactionId() { return transactionId; }
    public String getMetodoPago() { return metodoPago; }
    public double getMonto() { return monto; }
}