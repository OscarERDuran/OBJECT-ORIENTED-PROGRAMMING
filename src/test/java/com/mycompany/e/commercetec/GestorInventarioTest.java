package com.mycompany.e.commercetec;

import com.mycompany.e.commercetec.exceptions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GestorInventarioTest {
    private GestorInventarioFisico gestor;
    private ProductoFisico producto;
    
    @BeforeEach
    void setUp() {
        gestor = new GestorInventarioFisico();
        producto = new ProductoFisico(1, "Laptop", "Laptop gaming", 1500000, 10, 2.5, "30x20x5");
    }
    
    @Test
    @DisplayName("Agregar producto físico válido")
    void testAgregarProductoValido() {
        assertDoesNotThrow(() -> gestor.añadirProducto(producto));
        assertEquals(1, gestor.obtenerInventario().size());
    }
    
    @Test
    @DisplayName("Error al agregar producto nulo")
    void testAgregarProductoNulo() {
        ECommerceException exception = assertThrows(
            ECommerceException.class,
            () -> gestor.añadirProducto(null)
        );
        assertEquals("El producto no puede ser nulo", exception.getMessage());
        assertEquals("PRODUCTO_NULO", exception.getCodigoError());
    }
    
    @Test
    @DisplayName("Error al agregar producto digital a inventario físico")
    void testAgregarProductoTipoIncorrecto() {
        ProductoDigital productoDigital = new ProductoDigital(2, "Curso", "Curso online", 100000, 50, "MP4", 1024);
        
        ECommerceException exception = assertThrows(
            ECommerceException.class,
            () -> gestor.añadirProducto(productoDigital)
        );
        assertEquals("Solo se pueden agregar productos físicos", exception.getMessage());
    }
    
    @Test
    @DisplayName("Actualizar stock exitosamente")
    void testActualizarStockExitoso() throws ECommerceException {
        gestor.añadirProducto(producto);
        
        assertDoesNotThrow(() -> gestor.actualizarStock(1, 20));
        assertEquals(20, gestor.buscarProducto(1).getStock());
    }
    
    @Test
    @DisplayName("Error al actualizar stock de producto inexistente")
    void testActualizarStockProductoInexistente() {
        ProductoNoEncontradoException exception = assertThrows(
            ProductoNoEncontradoException.class,
            () -> gestor.actualizarStock(999, 10)
        );
        assertEquals(999, exception.getProductoId());
    }
    
    @Test
    @DisplayName("Error al reducir stock insuficiente")
    void testReducirStockInsuficiente() throws ECommerceException {
        gestor.añadirProducto(producto);
        
        InventarioInsuficienteException exception = assertThrows(
            InventarioInsuficienteException.class,
            () -> gestor.reducirStock(1, 15)
        );
        assertEquals(1, exception.getProductoId());
        assertEquals(15, exception.getStockSolicitado());
        assertEquals(10, exception.getStockDisponible());
    }
}