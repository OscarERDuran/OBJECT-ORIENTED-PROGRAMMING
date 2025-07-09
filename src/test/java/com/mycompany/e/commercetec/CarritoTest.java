package com.mycompany.e.commercetec;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CarritoTest {
    private Carrito carrito;
    private Producto producto1;
    private Producto producto2;
    
    @BeforeEach
    void setUp() {
        carrito = new Carrito();
        producto1 = new Producto(1, "Laptop", "Laptop gaming", 1500000, 10);
        producto2 = new Producto(2, "Mouse", "Mouse inalámbrico", 50000, 20);
    }
    
    @Test
    @DisplayName("Crear carrito vacío")
    void testCrearCarritoVacio() {
        assertEquals(0, carrito.getCantidadProductos());
        assertEquals(0, carrito.getTotal());
    }
    
    @Test
    @DisplayName("Agregar producto al carrito")
    void testAgregarProducto() {
        assertDoesNotThrow(() -> carrito.agregarProducto(producto1));
        assertEquals(1, carrito.getCantidadProductos());
        assertEquals(1500000, carrito.getTotal());
    }
    
    @Test
    @DisplayName("Agregar múltiples productos")
    void testAgregarMultiplesProductos() {
        assertDoesNotThrow(() -> {
            carrito.agregarProducto(producto1);
            carrito.agregarProducto(producto2);
        });
        assertEquals(2, carrito.getCantidadProductos());
        assertEquals(1550000, carrito.getTotal()); // 1500000 + 50000
    }
    
    @Test
    @DisplayName("Error al agregar producto nulo")
    void testAgregarProductoNulo() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> carrito.agregarProducto(null)
        );
        assertEquals("El producto no puede ser nulo", exception.getMessage());
    }
    
    @Test
    @DisplayName("Remover producto del carrito")
    void testRemoverProducto() {
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        assertEquals(2, carrito.getCantidadProductos());
        
        carrito.removerProducto(producto1);
        assertEquals(1, carrito.getCantidadProductos());
        assertEquals(50000, carrito.getTotal());
    }
    
    @Test
    @DisplayName("Vaciar carrito")
    void testVaciarCarrito() {
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        assertEquals(2, carrito.getCantidadProductos());
        
        carrito.vaciarCarrito();
        assertEquals(0, carrito.getCantidadProductos());
        assertEquals(0, carrito.getTotal());
    }
}