package com.mycompany.e.commercetec.exceptions;

public class InventarioInsuficienteException extends ECommerceException {
    private int stockDisponible;
    private int stockSolicitado;
    private int productoId;
    
    public InventarioInsuficienteException(int productoId, int stockSolicitado, int stockDisponible) {
        super(String.format("Stock insuficiente para el producto ID %d. Solicitado: %d, Disponible: %d", 
              productoId, stockSolicitado, stockDisponible), "STOCK_INSUFICIENTE");
        this.productoId = productoId;
        this.stockSolicitado = stockSolicitado;
        this.stockDisponible = stockDisponible;
    }
    
    public int getStockDisponible() { return stockDisponible; }
    public int getStockSolicitado() { return stockSolicitado; }
    public int getProductoId() { return productoId; }
}