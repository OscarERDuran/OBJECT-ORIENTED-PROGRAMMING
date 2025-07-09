package com.mycompany.e.commercetec;

import com.mycompany.e.commercetec.exceptions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

class PagoTarjetaTest {
    
    @Test
    @DisplayName("Crear pago con tarjeta válida")
    void testCrearPagoTarjetaValida() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                PagoTarjeta pagoTarjeta = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
            }
        });
    }
    
    @Test
    @DisplayName("Error con número de tarjeta inválido")
    void testTarjetaNumeroInvalido() {
        TarjetaInvalidaException exception = assertThrows(
            TarjetaInvalidaException.class,
            () -> new PagoTarjeta("123", "Juan Pérez", "12/25")
        );
        assertEquals("Número de tarjeta debe tener 16 dígitos", exception.getMessage());
    }
    
    @Test
    @DisplayName("Error con nombre de titular vacío")
    void testTarjetaNombreVacio() {
        TarjetaInvalidaException exception = assertThrows(
            TarjetaInvalidaException.class,
            () -> new PagoTarjeta("1234567890123456", "", "12/25")
        );
        assertEquals("Nombre del titular no puede estar vacío", exception.getMessage());
    }
    
    @Test
    @DisplayName("Error con formato de fecha inválido")
    void testTarjetaFechaInvalida() {
        TarjetaInvalidaException exception = assertThrows(
            TarjetaInvalidaException.class,
            () -> new PagoTarjeta("1234567890123456", "Juan Pérez", "2025/12")
        );
        assertEquals("Formato de fecha inválido (debe ser MM/YY)", exception.getMessage());
    }
    
    @Test
    @DisplayName("Error al iniciar pago con monto inválido")
    void testIniciarPagoMontoInvalido() throws TarjetaInvalidaException {
        PagoTarjeta pago = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
        
        PagoFallidoException exception = assertThrows(
            PagoFallidoException.class,
            () -> pago.iniciarPago(-100, "Compra inválida")
        );
        assertEquals("El monto debe ser positivo", exception.getMessage());
        assertEquals("PAGO_FALLIDO", exception.getCodigoError());
    }
    
    @Test
    @DisplayName("Verificar pago con ID válido")
    void testVerificarPagoValido() throws Exception {
        PagoTarjeta pago = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
        
        assertDoesNotThrow(() -> pago.verificarPago("TXN123456"));
    }
    
    @Test
    @DisplayName("Error al verificar pago con ID inválido")
    void testVerificarPagoIdInvalido() throws TarjetaInvalidaException {
        PagoTarjeta pago = new PagoTarjeta("1234567890123456", "Juan Pérez", "12/25");
        
        PagoFallidoException exception = assertThrows(
            PagoFallidoException.class,
            () -> pago.verificarPago("")
        );
        assertEquals("ID de transacción inválido", exception.getMessage());
    }
}